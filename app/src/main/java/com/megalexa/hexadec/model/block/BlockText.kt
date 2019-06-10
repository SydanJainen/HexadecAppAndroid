package com.megalexa.hexadec.model.block

class BlockText constructor(private var configuration:String): BlockInterface {
    private var text= configuration

    init{
        require(!(configuration.isEmpty())){
            println("Configuration is Empty")
        }
        require(configuration.length <= 255){
            println("Overflow Error, max length is 255")
        }
        require(configuration.length > 0){
            println("length is Empty")
        }
    }
    override fun getConfig(): String {
        return text
    }

     override fun getNameBlock(): String{
        return "TEXT"
    }

    override fun setConfig(configuration:String){
        text = configuration
    }
}