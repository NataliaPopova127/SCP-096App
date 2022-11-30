package com.example.scp_096App

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_action.*

class ActionActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    lateinit var mainAccentMusic : MediaPlayer
    var photo1Checked : Boolean = false
    var photo2Checked : Boolean = false
    var photo3Checked : Boolean = false
    var photo4Checked : Boolean = false
    var radiobutton : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        tvText.setText(R.string.text1)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        mainAccentMusic  = MediaPlayer.create(this, R.raw.step_sound)
        mainSplashMusic = MediaPlayer.create(this, R.raw.main_theme)
        if(mainSplashMusic.isPlaying != true)
            mainSplashMusic.start()
    }

    override fun onStop() {
        super.onStop()
        try{
            if(mainSplashMusic.isPlaying ){
                mainSplashMusic.stop()
            }
            if(mainAccentMusic.isPlaying){
                mainAccentMusic.stop()
            }
        }
       catch(e : Exception){
           Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
       }
    }

    private fun newScene(text : String, name : String, box : Int?, people : Int?, avatar : Int?){
        tvText.text = text
        tvName.text = name
        if(box == null){
            imgBox.isVisible = false
        }
        else{
            imgBox.isVisible = true
            imgBox.setImageResource(box)
        }

        if(people == null){
            imgPeople.isVisible = false
        }
        else{
            imgPeople.isVisible = true
            imgPeople.setImageResource(people)
        }

        if(avatar == null){
            imgAvatar.isVisible = false
        }
        else{
            imgAvatar.isVisible = true
            imgAvatar.setImageResource(avatar)
        }


    }

    fun radioButtonClick(view: View) {
        imgBox.isVisible = true
        if(view.id == R.id.rbPhoto1){
            photo1Checked = true
            tvText.text = getString(R.string.photo_text1)

            imgBox.setImageDrawable(getDrawable(R.drawable.photo1))
        }
        else if(view.id == R.id.rbPhoto2){
            mainAccentMusic = MediaPlayer.create(this, R.raw.accent_music)
            mainAccentMusic.start()
            photo2Checked = true
            tvText.text = getString(R.string.photo_text2)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo2))
            rbPhoto3.isVisible = true;
            rbPhoto4.isVisible = true;
        }
        else if(view.id == R.id.rbPhoto3){
            photo3Checked = true
            tvText.text = getString(R.string.photo_text3)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo3))
        }
        else if(view.id == R.id.rbPhoto4){
            photo4Checked = true
            tvText.text = getString(R.string.photo_text4)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo4))
        }
    }

    fun tvTextClick(view: View){

        if(tvText.text == getString(R.string.text1)){
            newScene(getString(R.string.text2), getString(R.string.name_security),
            null, R.drawable.security2, R.drawable.security_avatar)
        }
        else if(tvText.text == getString(R.string.text2)){
            newScene(getString(R.string.text3), getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
            imgBackGround.setBackgroundResource(R.drawable.room_2)
        }
        else if(tvText.text == getString(R.string.text3)){
            newScene(getString(R.string.text4), getString(R.string.name_doctor), null,
               null, R.drawable.scientist_avatar)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text4)){
            newScene(getString(R.string.text5), getString(R.string.name_doctor), null,
                null, R.drawable.scientist_avatar)
        }
        else if(tvText.text == getString(R.string.text5)){
            mainAccentMusic.stop()
            imgBackGround.setBackgroundResource(R.drawable.room_3)
            newScene(getString(R.string.text6), getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
        }
        else if(tvText.text == getString(R.string.text6)){
            newScene(getString(R.string.text7), getString(R.string.name_doctor),
                R.drawable.box, null, R.drawable.scientist_avatar)
        }
        else if(tvText.text == getString(R.string.text7)){
            imgBackGround.setBackgroundResource(R.drawable.room_table)
            newScene(getString(R.string.text8), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text8)){
            imgBackGround.setBackgroundResource(R.drawable.table)
            rbGroup.isVisible = true
            newScene(getString(R.string.text9), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(photo1Checked && photo2Checked && photo3Checked && photo4Checked){
            newScene(getString(R.string.text10), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
            rbGroup.isVisible = false

            mainAccentMusic.stop()
            mainAccentMusic  = MediaPlayer.create(this, R.raw.pencil_writing)
            mainAccentMusic.start()
            photo1Checked = false
            photo2Checked = false
            photo3Checked = false
            photo4Checked = false
        }
        else if(tvText.text == getString(R.string.text10)){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            newScene(getString(R.string.text11), getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
            imgBackGround.setBackgroundResource(R.drawable.room_3)
        }
        else if(tvText.text == getString(R.string.text11)){
            newScene(getString(R.string.text12), getString(R.string.name_my),
            null, null, R.drawable.class_d_avatar)

            imgBackGround.setBackgroundResource(R.drawable.room_4)
        }
        else if(tvText.text == getString(R.string.text12)){
            newScene(getString(R.string.text13), getString(R.string.name_my),
            null, null, R.drawable.class_d_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp096_run)
            mainAccentMusic  = MediaPlayer.create(this, R.raw.monster_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text13)){
            newScene(getString(R.string.text14), "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.black_image)
        }
        else if(tvText.text == getString(R.string.text14)){
            newScene(getString(R.string.text15), getString(R.string.name_doctor),null, R.drawable.scientist2,
                R.drawable.scientist_avatar)
            imgBackGround.background = getDrawable(R.drawable.room_4)
            mainAccentMusic  = MediaPlayer.create(this, R.raw.pencil_writing)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text15)){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            newScene(getString(R.string.text16), "", null, null, null)
            imgBackGround.background = getDrawable(R.drawable.black_image)
            mainAccentMusic  = MediaPlayer.create(this, R.raw.sound_2)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text16)){
            val intent : Intent = Intent(this@ActionActivity, MainActivity :: class.java)
            startActivity(intent)
            finish()
        }
    }
}