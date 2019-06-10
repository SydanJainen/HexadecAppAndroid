package com.megalexa.hexadec.model.block

class BlockSecurity constructor(private var configuration:String): BlockInterface {
    private val pin= configuration

    init{
        require(!(configuration.isEmpty())){
            println("Configuration is Empty")
        }
        require(configuration.length == 4){
            println("Overflow Error. Pin is composed by 4 symbol")
        }
    }

    override fun getConfig(): String {
        return pin
    }

    override fun getNameBlock(): String{
        return "SECURITY"
    }

    override fun setConfig(configuration:String){
    }
}