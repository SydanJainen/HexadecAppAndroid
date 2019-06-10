package com.megalexa.hexadec.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.megalexa.hexadec.R
import com.megalexa.hexadec.model.Workflow
import com.megalexa.hexadec.presenter.BlockPresenter
import com.megalexa.hexadec.presenter.contract.MainContract
import kotlinx.android.synthetic.main.feedrssview.*
import kotlinx.android.synthetic.main.feedrssview.textBlockConf
import kotlinx.android.synthetic.main.feedrssview.titleInsTextConf
import kotlinx.android.synthetic.main.workflow_view.my_toolbar

class FeedRssBlockActivity : AppCompatActivity(),MainContract.BlockView {

    internal lateinit var presenter: MainContract.BlockContract
    private lateinit var newWorkflow : Workflow
    private var url:String = ""

    override fun setPresenter(presenter: MainContract.BlockContract) {
       this.presenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feedrssview)
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.app_name)
        setPresenter(BlockPresenter(this@FeedRssBlockActivity))
        feedrssBlockbtnSalvab.setOnClickListener {
            val intent=Intent(this@FeedRssBlockActivity, AddBlocksActivity::class.java)
            intent.putExtra("Workflow",newWorkflow)
            startActivity(intent)
        }
        feedrssBlockbtnSalvaw.setOnClickListener {
            newWorkflow=presenter.addBlock(newWorkflow,url,"FEEDRSS")
            presenter.saveWorkflow(newWorkflow)
            startActivity(Intent(this@FeedRssBlockActivity, ViewActivity::class.java))
        }
        feedrssBlockbtnAnnulla.setOnClickListener {
            val intent=Intent(this@FeedRssBlockActivity, NewWorkflowActivity::class.java)
            intent.putExtra("Workflow",newWorkflow)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if ( item.itemId == R.id.settings) {
            startActivity(Intent(this@FeedRssBlockActivity, FeedRssBlockActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun onRadioButtonClicked(view: View) {
        when(view as RadioButton) {
            FeedCustom -> {
                titleInsTextConf.visibility = View.VISIBLE
                textBlockConf.visibility = View.VISIBLE
                url = textBlockConf.text.toString()
            }
            radio1 ->{
                url = "https://www.gazzetta.it/rss/serie-a.xml"
            }
            radio2 ->{
                url = "https://www.gazzetta.it/rss/serie-b.xml"
            }
            radio3 ->{
                url = "https://www.gazzetta.it/rss/motociclismo.xml"
            }
            FeedFormula ->{
                url = "https://www.gazzetta.it/rss/formula-1.xml"
            }
            FeedBasket ->{
                url = "https://www.gazzetta.it/rss/basket.xml"
            }
            else ->{
                titleInsTextConf.visibility = View.GONE
                textBlockConf.visibility = View.GONE
            }
        }
    }

    private fun startToast(message:String) {
        runOnUiThread {
            Toast.makeText(this@FeedRssBlockActivity,message, Toast.LENGTH_LONG).show()
        }
    }
}