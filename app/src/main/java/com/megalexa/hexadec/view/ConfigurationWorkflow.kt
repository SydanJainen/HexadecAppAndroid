package com.megalexa.hexadec.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.megalexa.hexadec.R
import com.megalexa.hexadec.presenter.adapter.recyclerViewConfigurationAdapter
import kotlinx.android.synthetic.main.workflow_view.*


class ConfigurationWorkflow: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workflow_configuration_view)
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //lateinit var blocks_list : List<recyclerViewConfigurationAdapter.RowType>

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewConf)
        val rows = mutableListOf<recyclerViewConfigurationAdapter.RowType>()
        rows.add(recyclerViewConfigurationAdapter.TextRow("Testo1","1","Messaggio1"))
        rows.add(recyclerViewConfigurationAdapter.FeedRssRow("Feed1","2","Custom","www.google.it"))
        Log.d("elementi",rows[0].toString())
        Log.d("elementi",rows[1].toString())
        recyclerView.adapter = recyclerViewConfigurationAdapter(rows)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }


/*
    private fun PopolateRows(blockNumbers: Int, workflowCorrente: Workflow): List<recyclerViewConfigurationAdapter.RowType> {
        // da fare ciclo per parsare tutti i blocchi, e associare il tipo giusto nella nuova lista rows
        lateinit var rows : List<recyclerViewConfigurationAdapter.RowType> // da inizializzare con  i blocchi giusti
        for (i in 1..workflowCorrente.getWorkflowSize()) {
            if(workflowCorrente.getBlocks()[i])
            rows.add(recyclerViewConfigurationAdapter.HeaderRow(Randomiser.date(), Randomiser.word()))
            val numChildren = Randomiser.int(0, 10)
            for (j in 1..numChildren) {
                if(Randomiser.int(0, 1) > 0) {
                    rows.add(ContentAdapter.MessageRow(Randomiser.message()))
                } else {
                    rows.add(ContentAdapter.ColourRow(Randomiser.colour()))
                }
            }
        }
        return rows
    }*/

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if ( item.itemId == R.id.settings) {
            startActivity(Intent(this@ConfigurationWorkflow, SettingsActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()

    }

    private fun startToast(message:String) {
        runOnUiThread {
            Toast.makeText(this@ConfigurationWorkflow,message, Toast.LENGTH_LONG).show()
        }
    }
}