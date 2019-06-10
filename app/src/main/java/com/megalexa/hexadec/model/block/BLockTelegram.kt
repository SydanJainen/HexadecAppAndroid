package com.megalexa.hexadec.model.block

class BLockTelegram  constructor(private var configuration:String): BlockInterface {
    private var profile= configuration

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
        return profile
    }

    override fun getNameBlock(): String{
        return "TELEGRAM"
    }

    override fun setConfig(configuration:String){
        profile = configuration
    }
}