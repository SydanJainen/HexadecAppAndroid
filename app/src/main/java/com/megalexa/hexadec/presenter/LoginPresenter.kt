package com.megalexa.hexadec.presenter

import com.megalexa.hexadec.model.HexaDec
import com.megalexa.hexadec.model.HexadecUser
import com.megalexa.hexadec.model.Workflow
import com.megalexa.hexadec.presenter.contract.MainContract
import java.util.ArrayList

class LoginPresenter(view:MainContract.LoginView):MainContract.LoginContract {
    private var view:MainContract.LoginView? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun updateUser(userId:String,userName:String,userEmail:String){
        HexaDec.getInstance()
        val uLoggato = HexadecUser(userId, userName, userEmail)
        HexadecUserConnection.postOperation(HexadecUserConnection.convertToJSON(uLoggato))
        HexaDec.user(uLoggato)
    }

    override fun setUpWorkflow(){
        val workflows=ArrayList<Workflow>()
        val count = WorkflowConnection.getOperation(listOf(Pair("IDUser",HexaDec.user.getId()))).getJSONArray("Items").length()
        for(i in 0 until count){
            workflows.add(WorkflowConnection.convertFromJSON(WorkflowConnection.getOperation(listOf(Pair("IDUser",HexaDec.user.getId()))).getJSONArray("Items").getJSONObject(i)))
        }
        HexaDec.hexadec(workflows)
    }
}