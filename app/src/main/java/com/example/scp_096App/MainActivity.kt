package com.example.scp_096App


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    var isStory2 : String? = "false"
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Scp096_Launcher)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

            val sharedPref = getSharedPreferences(getString(R.string.pref_file_key),Context.MODE_PRIVATE) ?: return
            isStory2 = sharedPref.getString("isStory2", "false")

            if(isStory2 == "true"){
                btnStory2.setTextColor(resources.getColor(R.color.white))
            }
            mainSplashMusic  = MediaPlayer.create(this, R.raw.splash_theme)
            if(!mainSplashMusic.isPlaying)
                mainSplashMusic.start()
            mainSplashMusic.isLooping = true
        }
        catch(e : Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
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
    fun btnStory1Click(view : View){
        if(mainSplashMusic.isPlaying)
            mainSplashMusic.stop()
        val intent : Intent = Intent(this@MainActivity, Story1Activity::class.java)
        startActivity(intent)
        finish()
    }
    fun btnStory2Click(view : View){
        if(isStory2 == "true"){
            if(mainSplashMusic.isPlaying)
                mainSplashMusic.stop()

            val intent : Intent = Intent(this@MainActivity, Story2Activity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Заблокировано")
                .setMessage("Чтобы открыть, пройдите день 1 и выживите")
                .setPositiveButton("ОК") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
            builder.show()
        }

    }
    fun btnAboutProgramClick(view: View) {
        val intent : Intent = Intent(this@MainActivity, AboutProgramActivity::class.java)
        startActivity(intent)
        finish()
    }

}