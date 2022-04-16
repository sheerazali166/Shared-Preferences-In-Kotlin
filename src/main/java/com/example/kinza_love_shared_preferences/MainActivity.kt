 package com.example.kinza_love_shared_preferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

    lateinit var kinzaSharedPreferencesConfig: Kinza_Shared_Preferences_Config

    lateinit var editTextUserKinza: EditText

    lateinit var editTextPasswordKinza: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kinzaSharedPreferencesConfig = Kinza_Shared_Preferences_Config(application)

        editTextUserKinza = findViewById(R.id.editTextKinzaUsername)

        editTextPasswordKinza = findViewById(R.id.editTextPasswordKinza)

        if(kinzaSharedPreferencesConfig.kinza_read_preferences()){

            startActivity(Intent(this, KinzaSuccessActivity::class.java))

            finish()
        }

    }

    fun kinza_click_login(view: android.view.View) {

        var kinzaUsername:String = editTextUserKinza.text.toString()

        var kinzaPassword:String = editTextPasswordKinza.text.toString()

        var uname_kinza = resources.getString(R.string.kinza_user_name)

        var pass_kinza = resources.getString(R.string.kinza_password)

        if(kinzaUsername.equals(uname_kinza) && kinzaPassword.equals(pass_kinza)){

            kinzaSharedPreferencesConfig.kinza_write_preferences(true)

            startActivity(Intent(this, KinzaSuccessActivity::class.java))

            finish()

            Toast.makeText(this, "Kinza Login Successful!!", Toast.LENGTH_LONG).show()
        }
        else{

            Toast.makeText(this, "Kinza Login Failed.", Toast.LENGTH_LONG).show()
        }


    }
}