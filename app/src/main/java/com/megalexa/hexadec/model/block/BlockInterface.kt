package com.megalexa.hexadec.model.block

interface BlockInterface {
    fun getConfig(): String
    fun getNameBlock():String
    fun setConfig(configuration:String)
}