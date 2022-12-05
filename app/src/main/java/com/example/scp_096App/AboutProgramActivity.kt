package com.example.scp_096App

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_action.*

class AboutProgramActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_program)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        mainSplashMusic = MediaPlayer.create(this, R.raw.main_theme)
        if(!mainSplashMusic.isPlaying)
            mainSplashMusic.start()
    }
    fun ivButtonMainMenuClick(view : View){
        var intent : Intent = Intent(this@AboutProgramActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun onStop() {
        super.onStop()
        try{
            if(mainSplashMusic.isPlaying ){
                mainSplashMusic.stop()
            }
        }
        catch(e : Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}