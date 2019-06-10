package com.megalexa.hexadec.model.block

import com.megalexa.hexadec.R
import com.megalexa.hexadec.utils.ApplicationContext

class BlockInstagram(private var configuration:String): BlockInterface {
    private var instagramProfile = configuration
    private var APIKey =""// ApplicationContext.sContext!!.resources!!.getString(R.string.Instagram_API)

    init{
        require(!(configuration.isEmpty())){
            println("Configuration is Empty")
        }
        require(instagramProfile.isNotEmpty()){
            println("Profile is Empty")
        }
    }

    fun setApi(api:String){
        APIKey=api
    }

    override fun getConfig(): String {
        return instagramProfile
    }

    override fun getNameBlock(): String{
        return "INSTAGRAM"
    }
     override fun setConfig(configuration:String){
         instagramProfile=configuration
     }
}
