package com.megalexa.hexadec.presenter

import com.megalexa.hexadec.model.HexaDec
import com.megalexa.hexadec.model.Workflow
import com.megalexa.hexadec.model.block.*
import com.megalexa.hexadec.presenter.contract.MainContract
import org.json.JSONObject
import java.util.ArrayList

class BlockPresenter (view: MainContract.BlockView): MainContract.BlockContract {
    private var view: MainContract.BlockView? = view

    override fun saveWorkflow(workflow: Workflow) {
        Thread {
            WorkflowConnection.postOperation(WorkflowConnection.convertToJSON(workflow))
            setUpWorkflow()
        }.start()
    }

    override fun saveBlock(workflow: Workflow) {
        Thread {
            val json = JSONObject()
            val blocks = workflow.getBlocks()
            for (w in 0 until blocks.size) {
                when(blocks[w].getNameBlock()){
                    "TEXT"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("TextValue", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                    "INSTAGRAM"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("URLValue", workflow.getBlocks()[w].getConfig())
                        BlockInstagramConnection.postOperation(json)
                    }
                    "FILTRO"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("TextValue", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                    "WEATHER"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("city", workflow.getBlocks()[w].getConfig())
                        BlockWeatherConnection.postOperation(json)
                    }
                    "SECURITY"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("PIN", workflow.getBlocks()[w].getConfig())
                        BlockSecurityConnection.postOperation(json)
                    }
                    "YOUTUBEMUSIC"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("URLValue", workflow.getBlocks()[w].getConfig())
                        BlockYouTubeMusicConnection.postOperation(json)
                    }
                    "YOUTUBE"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("URLValue", workflow.getBlocks()[w].getConfig())
                        BlockYouTubeConnection.postOperation(json)
                    }
                    "TELEGRAM"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("profile", workflow.getBlocks()[w].getConfig())
                        BlockTelegramConnection.postOperation(json)
                    }
                    "RADIO"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("URLValue", workflow.getBlocks()[w].getConfig())
                        BlockRadioConnection.postOperation(json)
                    }
                    "KINDLE"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("URLValue", workflow.getBlocks()[w].getConfig())
                        BlockKindleConnection.postOperation(json)
                    }
                    //facoltativi
                    "FACEBOOK"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("profile", workflow.getBlocks()[w].getConfig())
                        BlockFacebookConnection.postOperation(json)
                    }
                    "SLACK"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("profile", workflow.getBlocks()[w].getConfig())
                        BlockSlackConnection.postOperation(json)
                    }
                    "CALENDARIO"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("profile", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                    "CINEMA"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("url", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                    "TRASPORTI"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("TextValue", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                    "LISTA"->{
                        json.put("IDUser", HexaDec.user.getId())
                        json.put("WorkflowName", workflow.getWorkflowName())
                        json.put("TextValue", workflow.getBlocks()[w].getConfig())
                        BlockTextConnection.postOperation(json)
                    }
                }
            }
        }
    }

    override fun addBlock(workflow: Workflow, configuration: String, type: String): Workflow {
        when(type) {
            "TEXT" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "INSTAGRAM" -> {
                workflow.addBlockToWorkflow(BlockInstagram(configuration))
            }
            "FILTRO" -> {
                workflow.addBlockToWorkflow(BlockFilter(configuration))
            }
            "WEATHER" -> {
                workflow.addBlockToWorkflow(BlockWeather(configuration))
            }
            "SECURITY" -> {
                workflow.addBlockToWorkflow(BlockSecurity(configuration))
            }
            "YOUTUBEMUSIC" -> {
                workflow.addBlockToWorkflow(BlockYouTubeMusic(configuration))
            }
            "YOUTUBE" -> {
                workflow.addBlockToWorkflow(BlockYouTube(configuration))
            }
            "TELEGRAM" -> {
                workflow.addBlockToWorkflow(BLockTelegram(configuration))
            }
            "RADIO" -> {
                workflow.addBlockToWorkflow(BlockRadio(configuration))
            }
            "KINDLE" -> {
                workflow.addBlockToWorkflow(BlockKindle(configuration))
            }
            "FACEBOOK" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "SLACK" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "CALENDARIO" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "CINEMA" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "TRASPORTI" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
            "LISTA" -> {
                workflow.addBlockToWorkflow(BlockText(configuration))
            }
        }
        return workflow
    }

    private fun setUpWorkflow(){
        val workflows= ArrayList<Workflow>()
        val count = WorkflowConnection.getOperation(listOf(Pair("IDUser", HexaDec.user.getId()))).getJSONArray("Items").length()
        for(i in 0 until count){
            workflows.add(
                WorkflowConnection.convertFromJSON(WorkflowConnection.getOperation(listOf(Pair("IDUser",HexaDec.user.getId()))).getJSONArray("Items").getJSONObject(i)))
        }
        HexaDec.hexadec(workflows)
    }

    override fun onDestroy() {
        this.view = null
    }
}