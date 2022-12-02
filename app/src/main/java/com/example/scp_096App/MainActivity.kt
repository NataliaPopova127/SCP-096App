package com.example.scp_096App

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Pract19_Launcher)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        mainSplashMusic  = MediaPlayer.create(this, R.raw.splash_theme)

        if(mainSplashMusic.isPlaying != true)
            mainSplashMusic.start()
        mainSplashMusic.isLooping = true
    }


    fun startMenuClick(view : View){
        if(mainSplashMusic.isPlaying)
            mainSplashMusic.stop()
        val intent : Intent = Intent(this@MainActivity, ActionActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun btnAboutProgramClick(view: View) {
        val intent : Intent = Intent(this@MainActivity, AboutProgramActivity::class.java)
        startActivity(intent)
        finish()
    }
}