package com.example.scp_096App

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


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
    fun btnDeleteScoreClick(view : View){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Удаление")
            .setMessage("Вы уверены, что хотите удалить текущий результат?")
            .setPositiveButton("Да") {
                    dialog, id -> save()
            }
            .setNegativeButton("Нет"){
                    dialog, id -> dialog.cancel()
            }
        builder.create()
        builder.show()

    }
    fun save(){
        val sharedPref = getSharedPreferences(getString(R.string.pref_file_key), Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("isStory2", "false")
            apply()
        }
    }
}