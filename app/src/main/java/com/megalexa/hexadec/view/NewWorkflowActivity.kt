package com.megalexa.hexadec.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.megalexa.hexadec.R
import com.megalexa.hexadec.model.Workflow
import kotlinx.android.synthetic.main.activity_new_workflow.*

import kotlinx.android.synthetic.main.workflow_view.my_toolbar

class NewWorkflowActivity: AppCompatActivity(){
    private lateinit var newWorkflow: Workflow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_workflow)
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if(intent.hasExtra("Workflow")){
            newWorkflow=intent.getSerializableExtra("Workflow") as Workflow
            findViewById<EditText>(R.id.WorkflowName).setText(newWorkflow.getWorkflowName())
            findViewById<EditText>(R.id.WorkflowWelcomeText).setText(newWorkflow.getWelcomeText())
        }
         ConfigurationBlock.setOnClickListener {
             newWorkflow = Workflow(findViewById<EditText>(R.id.WorkflowName).text.toString(),"","",0)
             newWorkflow.setWelcomeText(findViewById<EditText>(R.id.WorkflowWelcomeText).text.toString())
             val intent=Intent(this@NewWorkflowActivity, AddBlocksActivity::class.java)
             intent.putExtra("Workflow",newWorkflow)
             startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if ( item.itemId == R.id.settings) {
            startActivity(Intent(this@NewWorkflowActivity, SettingsActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startToast(message:String) {
        runOnUiThread {
            Toast.makeText(this@NewWorkflowActivity,message, Toast.LENGTH_LONG).show()
        }
    }
}