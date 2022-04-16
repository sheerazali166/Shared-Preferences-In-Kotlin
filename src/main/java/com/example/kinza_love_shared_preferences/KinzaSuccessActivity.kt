package com.example.kinza_love_shared_preferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KinzaSuccessActivity : AppCompatActivity() {

   lateinit var kinzaSharedPreferencesConfig: Kinza_Shared_Preferences_Config

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kinza_success)

        kinzaSharedPreferencesConfig = Kinza_Shared_Preferences_Config(application)
    }

    fun kinza_click_logout(view: android.view.View) {

        kinzaSharedPreferencesConfig.kinza_write_preferences(false)

        startActivity(Intent(this, MainActivity::class.java))

        finish()
    }
}