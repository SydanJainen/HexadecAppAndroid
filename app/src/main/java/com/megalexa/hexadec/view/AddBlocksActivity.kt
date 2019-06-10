
package com.megalexa.hexadec.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.megalexa.hexadec.R
import com.megalexa.hexadec.model.Workflow
import com.megalexa.hexadec.presenter.BlockListAdapter
import kotlinx.android.synthetic.main.addblock_gridview.*
import kotlinx.android.synthetic.main.workflow_view.my_toolbar


class AddBlocksActivity: AppCompatActivity() {

    private lateinit var newWorkflow:Workflow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addblock_gridview)
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val gridView = findViewById<GridView>(R.id.gridview)
        val arrayListImage = ArrayList<Int>()

        arrayListImage.add(R.drawable.text_icon2)
        arrayListImage.add(R.drawable.feedrss_icon)
        arrayListImage.add(R.drawable.filter_icon)
        arrayListImage.add(R.drawable.instagram_icon)
        arrayListImage.add(R.drawable.radio)//radio
        arrayListImage.add(R.drawable.meteo)//meteo
        arrayListImage.add(R.drawable.youtube)//yt
        arrayListImage.add(R.drawable.youtubemusic)//ytm
        arrayListImage.add(R.drawable.securitykey)//security
        arrayListImage.add(R.drawable.telegram)//telegram
        arrayListImage.add(R.drawable.pdf_icon)//kindle
        arrayListImage.add(R.drawable.slack)//slack
        newWorkflow  = intent.getSerializableExtra("Workflow") as Workflow
        val name = arrayOf("Testo", "FeedRSS", "Fitro", "Instagram","Radio","Meteo","YouTube","YouTubeMusic","Security","Telegram","Kindle","Slack")
        val customAdapter = BlockListAdapter(this@AddBlocksActivity, arrayListImage, name)
        gridView.adapter = customAdapter
        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            when(position){
                0-> {
                    val intentText= Intent(this@AddBlocksActivity, BlockActivity::class.java)
                    intentText.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentText)
                }
                1->{
                    val intentFeed= Intent(this@AddBlocksActivity, FeedRssBlockActivity::class.java)
                    intentFeed.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFeed)
                }
                2->{
                    val intentFilter= Intent(this@AddBlocksActivity, FilterBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                3-> { val intentFilter=Intent(this@AddBlocksActivity, InstagramBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                4-> { val intentFilter=Intent(this@AddBlocksActivity, RadioBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                5-> { val intentFilter=Intent(this@AddBlocksActivity, WeatherBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                6-> { val intentFilter=Intent(this@AddBlocksActivity, YouTubeBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                7-> { val intentFilter=Intent(this@AddBlocksActivity, YouTubeMusicBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                8-> { val intentFilter=Intent(this@AddBlocksActivity, SecurityBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                9-> { val intentFilter=Intent(this@AddBlocksActivity, TelegramBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                10-> { val intentFilter=Intent(this@AddBlocksActivity, KindleBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
                11-> { val intentFilter=Intent(this@AddBlocksActivity, SlackBlockActivity::class.java)
                    intentFilter.putExtra("WorkFlow",newWorkflow)
                    startActivity(intentFilter)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if ( item.itemId == R.id.settings) {
            startActivity(Intent(this@AddBlocksActivity, SettingsActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        if( intent.hasExtra("Workflow")) {
            newWorkflow = intent.getSerializableExtra("Workflow") as Workflow
        }
        else{

        }
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun startToast(message:String) {
        runOnUiThread {
            Toast.makeText(this@AddBlocksActivity,message,Toast.LENGTH_LONG).show()
        }
    }
}