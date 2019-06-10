package com.megalexa.hexadec.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

import com.megalexa.hexadec.R
import com.megalexa.hexadec.presenter.WorkflowPresenter
import com.megalexa.hexadec.presenter.contract.MainContract
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.workflow_view.*
import android.content.Intent
import com.amazon.identity.auth.device.AuthError
import com.amazon.identity.auth.device.api.Listener
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager
import com.megalexa.hexadec.model.Workflow

class ViewActivity : AppCompatActivity(), MainContract.WorkflowView {
    internal lateinit var presenter: MainContract.WorkflowContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workflow_view)
        setSupportActionBar(my_toolbar)
        supportActionBar?.run{setHomeButtonEnabled(true)}
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewConf)
        setPresenter(WorkflowPresenter(this@ViewActivity))
    }

    override fun updateView(workflowList: Array<Workflow>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.new_menu, menu)
        //val myMenuItem = menu.findItem(R.id.action_langItaliano)
        //val myMenuItem2 = menu.findItem(R.id.action_langEnglish)
       // getMenuInflater().inflate(R.menu.sub_menu, myMenuItem.getSubMenu());
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if ( item.itemId == R.id.settings) {
                startActivity(Intent(this@ViewActivity, SettingsActivity::class.java))
                return true
            }
        if ( item.itemId == R.id.logout) { // da aggiornare nelle altre view
            AuthorizationManager.signOut(applicationContext, object: Listener<Void, AuthError> {
                override fun onSuccess(response: Void?) =
                    startActivity(Intent(this@ViewActivity, MainActivity::class.java))

                override fun onError(authError: AuthError) {
                    return
                }
            })
           /* if (item.itemId==R.id.home){
                onBackPressed()
                return true
            }*/
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onStart(){
        super.onStart()
        this@ViewActivity.runOnUiThread(java.lang.Runnable {
            presenter.popolateView(this@ViewActivity,recyclerViewConf)
        })
        btn_new_workflow.setOnClickListener {
            startToast("Add New Workflow")
            startActivity(Intent(this@ViewActivity, NewWorkflowActivity::class.java))
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.WorkflowContract) {
        this.presenter=presenter
    }

    override fun onRestart() {
        super.onRestart()
        this@ViewActivity.runOnUiThread(java.lang.Runnable {
            presenter.popolateView(this@ViewActivity,recyclerViewConf)
        })
    }

     private fun startToast(message:String) {
        runOnUiThread {
            Toast.makeText(this@ViewActivity,message,Toast.LENGTH_LONG).show()
        }
    }
}
