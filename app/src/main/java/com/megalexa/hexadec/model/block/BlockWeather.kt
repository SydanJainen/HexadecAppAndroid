package com.megalexa.hexadec.model.block

import com.megalexa.hexadec.R
import com.megalexa.hexadec.utils.ApplicationContext

class BlockWeather  constructor(private val configuration:String): BlockInterface {
    private var city= configuration
    private var APIKey =""//ApplicationContext.sContext!!.resources!!.getString(R.string.Weather_API)


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

    fun setApi(api:String){
        APIKey=api
    }

    override fun getConfig(): String {
        return city
    }

    override fun getNameBlock(): String{
        return "WEATHER"
    }

    override fun setConfig(configuration:String){
        city = configuration
    }
}