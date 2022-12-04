package com.example.scp_096App

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_action.*


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.ivButtonMusic

class MainActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    var isMusic : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Pract19_Launcher)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        var result : Bundle? = intent.extras
        if(result != null){
            isMusic = result.getBoolean("isMusic")
        }

        mainSplashMusic  = MediaPlayer.create(this, R.raw.splash_theme)
        if(!mainSplashMusic.isPlaying && isMusic)
            mainSplashMusic.start()
        if(!isMusic)
            ivButtonMusic.setImageResource(R.drawable.btn_not_music)
        mainSplashMusic.isLooping = true
    }


    fun startMenuClick(view : View){
        if(mainSplashMusic.isPlaying)
            mainSplashMusic.stop()
        val intent : Intent = Intent(this@MainActivity, ActionActivity::class.java)
        intent.putExtra("isMusic", isMusic)
        startActivity(intent)
        finish()
    }

    fun btnAboutProgramClick(view: View) {
        val intent : Intent = Intent(this@MainActivity, AboutProgramActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun ivButtonMusicClick(view : View){
        if(isMusic){
            ivButtonMusic.setImageResource(R.drawable.btn_not_music)
            mainSplashMusic.pause()
            isMusic = false
        }
        else{
            ivButtonMusic.setImageResource(R.drawable.btn_music)
            mainSplashMusic.start()
            isMusic = true
        }
    }
}