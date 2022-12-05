package com.example.scp_096App


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    var isMusic : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Pract19_Launcher)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        var result : Bundle? = intent.extras
        if(result != null){
            isMusic = result.getBoolean("isMusic")
        }

        mainSplashMusic  = MediaPlayer.create(this, R.raw.splash_theme)
        if(!mainSplashMusic.isPlaying)
            mainSplashMusic.start()
        mainSplashMusic.isLooping = true
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

    }

}