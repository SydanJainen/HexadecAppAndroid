package com.megalexa.hexadec.model.block

class BlockFilter constructor(private var configuration:String): BlockInterface {
    private var limit= configuration
    private lateinit var block : BlockInterface

    init{
        require(!(configuration.isEmpty())){
            println("Configuration is Empty")
        }
        require(configuration.length == 4){
            println("Overflow Error. Pin is composed by 4 symbol")
        }
    }

    override fun getConfig(): String {
        return limit
    }

    fun setBlock(block:BlockInterface){
        this.block = block
    }

    override fun getNameBlock(): String{
        return "LIMIT"
    }

    override fun setConfig(configuration: String) {
        limit=configuration
    }
}