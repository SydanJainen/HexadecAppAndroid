package com.megalexa.hexadec.model.block

class BlockRadio constructor(private var configuration:String): BlockInterface {
    private var radio= configuration

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
        return radio
    }

    override fun getNameBlock(): String{
        return "RADIO"
    }

    override fun setConfig(configuration:String){
        radio = configuration
    }
}