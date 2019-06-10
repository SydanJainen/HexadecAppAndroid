package com.megalexa.hexadec.presenter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.megalexa.hexadec.R
import com.megalexa.hexadec.model.Workflow
import com.megalexa.hexadec.view.ConfigurationWorkflow
import kotlinx.android.synthetic.main.workflow_item.view.*

class recyclerViewWorkflowAdapter (val workflowList: ArrayList<Workflow>) : RecyclerView.Adapter<recyclerViewWorkflowAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.workflow_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workflowList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workflow: Workflow = workflowList[position]
        holder?.textViewName?.text = workflow.getWorkflowName()
        holder?.textViewDate?.text = workflow.getCreationDate()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewName =  itemView.findViewById<TextView>(R.id.textViewWorkflowName)
        val textViewDate =  itemView.findViewById<TextView>(R.id.textViewWorkflowCreateDate)
        init{
            itemView.setOnClickListener{
               val intent = Intent(itemView.context, ConfigurationWorkflow::class.java)
                intent.putExtra("workflowCorrente", itemView.textViewWorkflowName.toString())
                itemView.context.startActivity(intent)
            }
        }
    }
}