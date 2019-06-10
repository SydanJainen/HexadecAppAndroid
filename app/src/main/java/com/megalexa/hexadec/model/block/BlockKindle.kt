package com.megalexa.hexadec.model.block

class BlockKindle constructor(private var configuration:String): BlockInterface {
    private var pdf= configuration

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
        return pdf
    }

    override fun getNameBlock(): String{
        return "KINDLE"
    }

    override fun setConfig(configuration:String){
        pdf = configuration
    }
}