package com.example.scp_096App

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
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
    var eye : String = ""
    var radiobutton : Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)

        tvText.setText(R.string.text1)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        mainAccentMusic  = MediaPlayer.create(this, R.raw.step_sound)
        mainSplashMusic = MediaPlayer.create(this, R.raw.main_theme)
        if(mainSplashMusic.isPlaying != true)
            mainSplashMusic.start()
        mainSplashMusic.isLooping = true
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

    fun ivButtonMainMenuClick(view : View){
        var intent : Intent = Intent(this@ActionActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun radioButtonClick(view: View) {

       var button : RadioButton = findViewById(view.id)
        if(button.text == getString(R.string.photo1)){
            imgBox.isVisible = true
            photo1Checked = true
            tvText.text = getString(R.string.photo_text1)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo1))
            rbAnswer1.isVisible = false
        }
        else if(button.text == getString(R.string.photo2)){
            imgBox.isVisible = true
            mainAccentMusic = MediaPlayer.create(this, R.raw.accent_music)
            mainAccentMusic.start()
            photo2Checked = true
            tvText.text = getString(R.string.photo_text2)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo2))
            rbAnswer3.isVisible = true;
            rbAnswer4.isVisible = true;
            rbAnswer2.isVisible = false
        }
        else if(button.text == getString(R.string.photo3)){
            imgBox.isVisible = true
            photo3Checked = true
            tvText.text = getString(R.string.photo_text3)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo3))
            rbAnswer3.isVisible = false
        }
        else if(button.text == getString(R.string.photo4)){
            imgBox.isVisible = true
            photo4Checked = true
            tvText.text = getString(R.string.photo_text4)
            imgBox.setImageDrawable(getDrawable(R.drawable.photo4))
            rbAnswer4.isVisible = false
        }
        else if(button.text == getString(R.string.text_switchOn)){
            newScene(getString(R.string.final1), "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.black_image)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == getString(R.string.text_switchOff)){
            newScene("(...)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_night)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == getString(R.string.text_run)){
            newScene(getString(R.string.final2), "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.black_image)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == getString(R.string.text_nothing)){
            newScene(getString(R.string.text25), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes0)
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true
            rbAnswer3.isVisible = true

            rbAnswer1.text = getString(R.string.eye1)
            rbAnswer2.text = getString(R.string.eye2)
            rbAnswer3.text = getString(R.string.eye3)
        }
        else if(button.text == getString(R.string.eye1)){
            eye = getString(R.string.eye1)
            newScene(getString(R.string.text26), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1)
            rbAnswer1.text = getString(R.string.hand1)
            rbAnswer2.text = getString(R.string.hand2)
            rbAnswer3.text = getString(R.string.hand3)
        }
        else if(button.text == getString(R.string.eye2)){
            eye = getString(R.string.eye2)
            newScene(getString(R.string.text26), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2)
            rbAnswer1.text = getString(R.string.hand1)
            rbAnswer2.text = getString(R.string.hand2)
            rbAnswer3.text = getString(R.string.hand3)
        }
        else if(button.text == getString(R.string.eye3)){
            eye = getString(R.string.eye3)
            newScene(getString(R.string.text26), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3)
            rbAnswer1.text = getString(R.string.hand1)
            rbAnswer2.text = getString(R.string.hand2)
            rbAnswer3.text = getString(R.string.hand3)
        }
        else if(button.text == getString(R.string.hand1)){
            newScene(getString(R.string.text27), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye == getString(R.string.eye1))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands1)
            else if(eye == getString(R.string.eye2))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands1)
            else if(eye == getString(R.string.eye3))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands1)
            rbGroup.isVisible = false
        }
        else if(button.text == getString(R.string.hand2)){
            newScene(getString(R.string.text27), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye == getString(R.string.eye1))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands2)
            else if(eye == getString(R.string.eye2))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands2)
            else if(eye == getString(R.string.eye3))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands2)
            rbGroup.isVisible = false
        }
        else if(button.text == getString(R.string.hand3)){
            newScene(getString(R.string.text27), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye == getString(R.string.eye1))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands3)
            else if(eye == getString(R.string.eye2))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands3)
            else if(eye == getString(R.string.eye3))
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands3)
            rbGroup.isVisible = false
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

            imgBackGround.setBackgroundResource(R.drawable.room_light)
        }
        else if(tvText.text == getString(R.string.text12)){
            newScene(getString(R.string.text13), getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
            rbGroup.isVisible = true
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true


            rbAnswer1.text = getString(R.string.text_switchOn)
            rbAnswer2.text = getString(R.string.text_switchOff)
        }
        else if(tvText.text == "(...)"){
            newScene(getString(R.string.text14), getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text14)){
            newScene("(....)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_1)
        }
        else if(tvText.text == "(....)"){
            newScene(getString(R.string.text15), getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text15)){
            newScene("(.....)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_2)
        }
        else if(tvText.text == "(.....)"){
            newScene(getString(R.string.text16), getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text16)){
            newScene("(......)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_3)
        }
        else if(tvText.text == "(......)"){
            newScene(getString(R.string.text17), getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text17)){
            newScene("(.......)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_4)
            mainAccentMusic = MediaPlayer.create(this, R.raw.step_sound_2)
            mainAccentMusic.start();
        }
        else if(tvText.text == "(.......)"){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.bed_sit_sound)
            mainAccentMusic.start();
            newScene(getString(R.string.text18), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes0)
        }
        else if(tvText.text == getString(R.string.text18)){
            newScene(getString(R.string.text19), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text19)){
            newScene(getString(R.string.text20), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text20)){
            newScene(getString(R.string.text21), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text21)){
            newScene(getString(R.string.text22), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text22)){
            newScene(getString(R.string.text23), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text23)){
            newScene(getString(R.string.text24), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
            rbGroup.isVisible = true
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true

            rbAnswer1.text = getString(R.string.text_run)
            rbAnswer2.text = getString(R.string.text_nothing)
        }
        else if(tvText.text == getString(R.string.text27)){
            newScene(getString(R.string.text28), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text28)){
            newScene(getString(R.string.text29), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text29)){
            newScene(getString(R.string.text30), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text30)){
            newScene(getString(R.string.text31), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text31)){
            newScene(getString(R.string.text32), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text32)){
            newScene(getString(R.string.text33), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text33)){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
            newScene(getString(R.string.text34), getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == getString(R.string.text34)){
            newScene(getString(R.string.text35), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.head_broken_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text35)){
            newScene(getString(R.string.text36), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == getString(R.string.text36)){
            newScene(getString(R.string.text37), getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes0)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.step_sound_2)
            mainAccentMusic.start()
        }
        else if(tvText.text == getString(R.string.text37)){
            imgBackGround.setBackgroundResource(R.drawable.report_3)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(tvText.text == getString(R.string.final2)){
            imgBackGround.setBackgroundResource(R.drawable.report_2)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(tvText.text == getString(R.string.final1)){
            imgBackGround.setBackgroundResource(R.drawable.report_1)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(btnContinue.text == "Конец"){
            var intent : Intent = Intent(this@ActionActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}