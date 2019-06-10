package com.megalexa.hexadec.model.block

import com.megalexa.hexadec.R
import com.megalexa.hexadec.utils.ApplicationContext

class BlockYouTubeMusic constructor(private val configuration:String): BlockInterface {
    private var url= configuration
    private var APIKey = ""//ApplicationContext.sContext!!.resources!!.getString(R.string.YouTubeMusic_API)

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
        return url
    }

    override fun getNameBlock(): String{
        return "YOUTUBEMUSIC"
    }

    override fun setConfig(configuration:String){
        url = configuration
    }
}