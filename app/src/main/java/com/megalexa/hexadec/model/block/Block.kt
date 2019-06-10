package com.megalexa.hexadec.model.block

class Block constructor(private val blockName:String,private val configuration:String) {

    fun getBlock(): BlockInterface {
        when(blockName) {
            "SECURITY"-> return BlockSecurity(configuration)
            "TEXT"-> return BlockText(configuration)
            "FEEDRSS"-> return BlockFeedRss(configuration)
            "INSTAGRTAM"-> return BlockInstagram(configuration)
            "KINDLE"-> return BlockKindle(configuration)
            "RADIO"-> return BlockRadio(configuration)
            "TELEGRAM"-> return BLockTelegram(configuration)
            "YOUTUBE"-> return BlockYouTube(configuration)
            "YOUTUBEMUSIC"-> return BlockYouTubeMusic(configuration)
            "WHEATER"-> return BlockWeather(configuration)
            "FILTER"-> return BlockFilter(configuration)
            else-> {
                return BlockText(configuration)
            }
        }
    }

    fun getConfig(): String {
        when(blockName) {
           "SECURITY"-> return BlockSecurity(configuration).getConfig()
            "TEXT"-> return BlockText(configuration).getConfig()
            "FEEDRSS"-> return BlockFeedRss(configuration).getConfig()
            "INSTAGRTAM"-> return BlockInstagram(configuration).getConfig()
            "KINDLE"-> return BlockKindle(configuration).getConfig()
            "RADIO"-> return BlockRadio(configuration).getConfig()
            "TELEGRAM"-> return BLockTelegram(configuration).getConfig()
            "YOUTUBE"-> return BlockYouTube(configuration).getConfig()
            "YOUTUBEMUSIC"-> return BlockYouTubeMusic(configuration).getConfig()
            "WHEATER"-> return BlockWeather(configuration).getConfig()
            "FILTER"-> return BlockFilter(configuration).getConfig()
            else-> {
                return BlockText(configuration).getConfig()
            }
        }
    }
}
