package com.example.scp_096App

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible

import kotlinx.android.synthetic.main.activity_action.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.Path

class ActionActivity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    lateinit var mainAccentMusic : MediaPlayer
    var photo1Checked : Boolean = false
    var photo2Checked : Boolean = false
    var photo3Checked : Boolean = false
    var photo4Checked : Boolean = false
    var eye : String = ""
    var isMusic : Boolean = true
    lateinit var text : List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        try{
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

            mainAccentMusic  = MediaPlayer.create(this, R.raw.step_sound)
            mainSplashMusic = MediaPlayer.create(this, R.raw.main_theme)
            if(!mainSplashMusic.isPlaying)
                mainSplashMusic.start()

            mainSplashMusic.isLooping = true

            val reader = BufferedReader(InputStreamReader(this.assets.open("story_text.txt"), "windows-1251"))
            text = reader.readLines()

            tvText.text = text[0]
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

    fun radioButtonClick(view: View) {
        rbAnswer1.isChecked = false
        rbAnswer2.isChecked = false
        rbAnswer3.isChecked = false
        rbAnswer4.isChecked = false
       var button : RadioButton = findViewById(view.id)
        if(button.text == text[9]){
            imgBox.isVisible = true
            photo1Checked = true
            tvText.text = text[13]
            imgBox.setImageResource(R.drawable.photo1)
            rbAnswer1.isVisible = false
        }
        else if(button.text == text[10]){
            imgBox.isVisible = true
            mainAccentMusic = MediaPlayer.create(this, R.raw.accent_music)
            mainAccentMusic.start()
            photo2Checked = true
            tvText.text = text[14]
            imgBox.setImageResource(R.drawable.photo2)
            rbAnswer3.isVisible = true;
            rbAnswer4.isVisible = true;
            rbAnswer2.isVisible = false
        }
        else if(button.text == text[11]){
            imgBox.isVisible = true
            photo3Checked = true
            tvText.text = text[15]
            imgBox.setImageResource(R.drawable.photo3)
            rbAnswer3.isVisible = false
        }
        else if(button.text == text[12]){
            imgBox.isVisible = true
            photo4Checked = true
            tvText.text = text[16]
            imgBox.setImageResource(R.drawable.photo4)
            rbAnswer4.isVisible = false
        }
        else if(button.text == text[22]){
            newScene(text[23], "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.black_image)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == text[21]){
            newScene("(...)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_night)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == text[35]){
            newScene(text[37], "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.black_image)
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        else if(button.text == text[36]){
            newScene(text[38], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes0)
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true
            rbAnswer3.isVisible = true

            rbAnswer1.text = text[39]
            rbAnswer2.text = text[40]
            rbAnswer3.text = text[41]
        }
        else if(button.text == text[39]){
            eye = text[39]
            newScene(text[42], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1)
            rbAnswer1.text = text[43]
            rbAnswer2.text = text[44]
            rbAnswer3.text = text[45]
        }
        else if(button.text == text[40]){
            eye = text[40]
            newScene(text[42], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2)
            rbAnswer1.text = text[43]
            rbAnswer2.text = text[44]
            rbAnswer3.text = text[45]
        }
        else if(button.text == text[41]){
            eye = text[41]
            newScene(text[42], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3)
            rbAnswer1.text = text[43]
            rbAnswer2.text = text[44]
            rbAnswer3.text = text[45]
        }
        else if(button.text == text[43]){
            newScene(text[46], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye ==text[39])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands1)
            else if(eye ==text[40])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands1)
            else if(eye == text[41])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands1)
            rbGroup.isVisible = false
        }
        else if(button.text == text[44]){
            newScene(text[46], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye ==text[39])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands2)
            else if(eye ==text[40])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands2)
            else if(eye == text[41])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands2)
            rbGroup.isVisible = false
        }
        else if(button.text == text[45]){
            newScene(text[46], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(eye ==text[39])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes1_hands3)
            else if(eye ==text[40])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes2_hands3)
            else if(eye == text[41])
                imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes3_hands3)
            rbGroup.isVisible = false
        }
    }

    fun btnContinueClick(view: View){

        if(tvText.text == text[0]){
            newScene(text[1], getString(R.string.name_security),
            null, R.drawable.security2, R.drawable.security_avatar)
        }
        else if(tvText.text == text[1]){
            newScene(text[2], getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
            imgBackGround.setBackgroundResource(R.drawable.room_2)
        }
        else if(tvText.text == text[2]){
            newScene(text[3], getString(R.string.name_doctor), null,
               null, R.drawable.scientist_avatar)
            mainAccentMusic.start()
        }
        else if(tvText.text == text[3]){
            newScene(text[4], getString(R.string.name_doctor), null,
                null, R.drawable.scientist_avatar)
        }
        else if(tvText.text == text[4]){
            mainAccentMusic.stop()
            imgBackGround.setBackgroundResource(R.drawable.room_3)
            newScene(text[5], getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
        }
        else if(tvText.text == text[5]){
            newScene(text[6], getString(R.string.name_doctor),
                R.drawable.box, null, R.drawable.scientist_avatar)
        }
        else if(tvText.text == text[6]){
            imgBackGround.setBackgroundResource(R.drawable.room_table)
            newScene(text[7], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[7]){
            imgBackGround.setBackgroundResource(R.drawable.table)
            rbGroup.isVisible = true
            newScene(text[8], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(photo1Checked && photo2Checked && photo3Checked && photo4Checked){
            newScene(text[17], getString(R.string.name_my), null,
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
        else if(tvText.text == text[17]){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            newScene(text[18], getString(R.string.name_doctor), null,
                R.drawable.scientist2, R.drawable.scientist_avatar)
            imgBackGround.setBackgroundResource(R.drawable.room_3)
        }
        else if(tvText.text == text[18]){
            newScene(text[19], getString(R.string.name_my),
            null, null, R.drawable.class_d_avatar)

            imgBackGround.setBackgroundResource(R.drawable.room_light)
        }
        else if(tvText.text == text[19]){
            newScene(text[20], getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
            rbGroup.isVisible = true
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true


            rbAnswer1.text = text[22]
            rbAnswer2.text = text[21]
        }
        else if(tvText.text == "(...)"){
            newScene(text[24], getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[24]){
            newScene("(....)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_1)
        }
        else if(tvText.text == "(....)"){
            newScene(text[25], getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[25]){
            newScene("(.....)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_2)
        }
        else if(tvText.text == "(.....)"){
            newScene(text[26], getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[26]){
            newScene("(......)", "", null, null, null)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_3)
        }
        else if(tvText.text == "(......)"){
            newScene(text[27], getString(R.string.name_my),
                null, null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[27]){
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
            newScene(text[28], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
            imgBackGround.setBackgroundResource(R.drawable.scp_scene_eyes0)
        }
        else if(tvText.text == text[28]){
            newScene(text[29], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[29]){
            newScene(text[30], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[30]){
            newScene(text[31], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text ==text[31]){
            newScene(text[32], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[32]){
            newScene(text[33], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[33]){
            newScene(text[34], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
            rbGroup.isVisible = true
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true

            rbAnswer1.text = text[35]
            rbAnswer2.text = text[36]
        }
        else if(tvText.text == text[46]){
            newScene(text[47], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[47]){
            newScene(text[48], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[48]){
            newScene(text[49], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[49]){
            newScene(text[50], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == text[50]){
            newScene(text[51], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[51]){
            newScene(text[52], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text == text[52]){
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.bit_head_sound)
            mainAccentMusic.start()
            newScene(text[53], getString(R.string.name_my), null,
                null, R.drawable.class_d_avatar)
        }
        else if(tvText.text == text[53]){
            newScene(text[54], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.head_broken_sound)
            mainAccentMusic.start()
        }
        else if(tvText.text ==text[54]){
            newScene(text[55], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
        }
        else if(tvText.text == text[55]){
            newScene(text[56], getString(R.string.name_scp), null,
                null, R.drawable.scp_avatar)
            imgBackGround.setBackgroundResource(R.drawable.room_close_eye_4)
            if(mainAccentMusic.isPlaying)
                mainAccentMusic.stop()
            mainAccentMusic = MediaPlayer.create(this, R.raw.step_sound_2)
            mainAccentMusic.start()
        }
        else if(tvText.text == text[56]){
            imgBackGround.setBackgroundResource(R.drawable.report_3)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(tvText.text == text[37]){
            imgBackGround.setBackgroundResource(R.drawable.report_2)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(tvText.text == text[23]){
            imgBackGround.setBackgroundResource(R.drawable.report_1)
            newScene("", "", null,
                null, null)
            btnContinue.text = "Конец"
        }
        else if(btnContinue.text == "Конец"){
            var intent : Intent = Intent(this@ActionActivity, MainActivity::class.java)
            intent.putExtra("isMusic", isMusic)
            startActivity(intent)
            finish()
        }
    }
}