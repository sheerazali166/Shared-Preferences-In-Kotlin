package com.example.kinza_love_shared_preferences

import android.content.Context
import android.content.SharedPreferences

class Kinza_Shared_Preferences_Config {

    var sharedPreferences:SharedPreferences? = null

    var content:Context? = null

    constructor(content: Context?) {
        this.content = content

    sharedPreferences = content?.getSharedPreferences(content.resources.getString(R.string.kinza_login_preferences), Context.MODE_PRIVATE)

    }

    fun kinza_write_preferences(status:Boolean){

        var editor:SharedPreferences.Editor = sharedPreferences!!.edit()

        editor.putBoolean(content!!.resources.getString(R.string.kinza_preferences_status), status)

        editor.commit()
    }

    fun kinza_read_preferences():Boolean{

        var status:Boolean = false

        status = sharedPreferences!!.getBoolean(content!!.getString(R.string.kinza_preferences_status), false)

        return status

    }
}