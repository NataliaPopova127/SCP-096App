package com.example.scp_096App

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutProgramActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_program)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }
    fun ivButtonMainMenuClick(view : View){
        var intent : Intent = Intent(this@AboutProgramActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}