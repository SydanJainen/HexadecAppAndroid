package com.megalexa.hexadec.model.block

class BlockFeedRss constructor(private var configuration:String): BlockInterface {
    private var url= configuration
    init {
        require(!(configuration.isEmpty())){
            println("Configuration is Empty")
        }
    }
    override fun getConfig(): String {
        return url
    }

    override fun getNameBlock(): String{
        return "FEEDRSS"
    }

    override fun setConfig(configuration:String){
        url=configuration
    }
}