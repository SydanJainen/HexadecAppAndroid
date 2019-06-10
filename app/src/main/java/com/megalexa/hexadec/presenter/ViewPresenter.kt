package com.megalexa.hexadec.presenter

import android.content.Context

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.megalexa.hexadec.presenter.contract.MainContract
import com.megalexa.hexadec.model.HexaDec


class WorkflowPresenter(view: MainContract.WorkflowView): MainContract.WorkflowContract {
    private var view:MainContract.WorkflowView? = view

    override fun onDestroy() {
        this.view = null
    }
    override fun popolateView(context: Context, view: RecyclerView){
        view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter = recyclerViewWorkflowAdapter(HexaDec.workflowList)
        view.adapter = adapter
    }
}