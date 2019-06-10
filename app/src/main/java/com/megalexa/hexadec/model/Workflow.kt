/*
 Nome file: Workflow.kt
 Type: Interface
 Data creazione: 2019-05-06

 Descrizione del file:
 Autore: Andrea Chinello
 Versione: v1.0.0
 Registro modifiche:
 Andrea, 2019-06-01 Definizione SettingContract e BlockContract
 Valentin, 2019-05-20, Definizione WorkflowContract
 Andrea, 2019-05-08, Definizione LoginContract
*/

package com.megalexa.hexadec.model

import com.megalexa.hexadec.model.block.BlockInterface
import java.io.Serializable
import kotlin.collections.ArrayList

class Workflow constructor(private var workflowName:String, private val creationDate:String, private val lastModifyDate:String, private val interaction:Int):Serializable {
    private var blockList: ArrayList<BlockInterface> = ArrayList()
    private var welcomeText = "welcome Text"
    private var idWorkflow = 0

    fun setIdWorkflow(value:Int){
        idWorkflow=value
    }

    fun getIdWorkflow():Int{
        return idWorkflow
    }

    fun setWelcomeText(value:String){
        welcomeText=value
    }

    fun getWelcomeText():String{
        return welcomeText
    }

    fun addBlockToWorkflow(block: BlockInterface){
        blockList.add(block)
    }

    fun getLastModifyDate():String{
        return lastModifyDate
    }

    fun getCreationDate():String{
        return creationDate
    }

    fun getInteraction(): Int {
        return interaction
    }

    fun getWorkflowSize():Int {
        return blockList.size
    }

    fun removeBlockFromWorkflow(block: BlockInterface) {
        blockList.remove(block)
    }

    fun getBlocks() : ArrayList<BlockInterface>{
        return blockList
    }

    fun getBlocks(user: HexadecUser) : ArrayList<BlockInterface>{
        //blockList = GatewayController.readBlocks( this)!!
        return blockList
    }

    fun setBlocks(blockList : ArrayList<BlockInterface>){
        this.blockList = blockList
    }

    override fun toString(): String {
        return getWorkflowName()
    }

    fun getWorkflowName() : String{
        return workflowName
    }
}