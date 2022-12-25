package com.example.scp_096App

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_story2.*
import java.io.BufferedReader
import java.io.InputStreamReader

class Story2Activity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    lateinit var mainAccentMusic : MediaPlayer
    lateinit var text : List<String>
    var firstClickMap : Boolean = true
    var firstClickFlashlight : Boolean = true
    var firstClickAccessCard : Boolean = true
    var backImage : String = "lab_7"
    var isMusic : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story2)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        mainAccentMusic = MediaPlayer.create(this, R.raw.take_material)
        mainSplashMusic = MediaPlayer.create(this, R.raw.music_runaway)
        if(!mainSplashMusic.isPlaying)
            mainSplashMusic.start()

        mainSplashMusic.isLooping = true

        val reader = BufferedReader(InputStreamReader(this.assets.open("story2_text.txt"), "UTF-8"))
        text = reader.readLines()
        tvText.text = text[0]
        rbAnswer1.text = getString(R.string.left)
        rbAnswer2.text = getString(R.string.right)
        rbAnswer3.text = getString(R.string.straight)
        rbAnswer4.text = getString(R.string.back)
    }
    override fun onStop() {
        super.onStop()
        if(mainSplashMusic.isPlaying)
            mainSplashMusic.stop()
        if(mainAccentMusic.isPlaying)
            mainAccentMusic.stop()
    }
    fun ivMapClick(view : View){
        if(firstClickMap){
            ivMaterial.isVisible = true
            ivMaterial.setImageDrawable(ivMap.drawable)
            firstClickMap = false
        }
        else{
            ivMaterial.isVisible = false
            firstClickMap = true
            firstClickAccessCard = true
            firstClickFlashlight = true
        }
    }
    fun ivFlashlightClick(view : View){
        if(firstClickFlashlight){
            ivMaterial.isVisible = true
            ivMaterial.setImageResource(R.drawable.flashlight)
            firstClickFlashlight = false
        }
        else{
            ivMaterial.isVisible = false
            firstClickMap = true
            firstClickAccessCard = true
            firstClickFlashlight = true
        }
    }
    fun ivAccessCardClick(view : View){
        if(firstClickAccessCard){
            ivMaterial.isVisible = true
            ivMaterial.setImageResource(R.drawable.access_card)
            firstClickAccessCard = false
        }
        else{
            ivMaterial.isVisible = false
            firstClickMap = true
            firstClickAccessCard = true
            firstClickFlashlight = true
        }
    }
    fun newScene(img : Int, textT : String, backImg : String, map : Int){
        back.setBackgroundResource(img)
        tvText.text = textT
        backImage = backImg
        ivMap.setImageResource(map)
    }
    fun radioButtonClick(view : View){
        rbAnswer1.isVisible = true
        rbAnswer2.isVisible = true
        if(view.id == R.id.rbAnswer2 && backImage == "lab_11"){
            newScene(R.drawable.lab_10, text[14], "lab_10", R.drawable.map_lab_10)
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_10"){
            if(ivFlashlight.isVisible){
                newScene(R.drawable.lab_3, text[7], "lab_3", R.drawable.map_lab_3)
            }
            else{
                mainAccentMusic.start()
                newScene(R.drawable.lab_3, text[10], "lab_3", R.drawable.map_lab_3)
                ivFlashlight.isVisible = true
            }
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_3"){
            newScene(R.drawable.lab_10, text[14], "lab_10", R.drawable.map_lab_10)
        }

        else if(view.id == R.id.rbAnswer4  && backImage == "lab_10"){
            newScene(R.drawable.lab_11, text[14], "lab_11", R.drawable.map_lab_11)
        }

        else if(view.id == R.id.rbAnswer1 && backImage == "lab_11"){
            if(ivFlashlight.isVisible){
                newScene(R.drawable.lab_5, text[14], "lab_5", R.drawable.map_lab_5)
            }
           else{
                newScene(R.drawable.black_image, text[9], "black", R.drawable.map_lab_5)
            }
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_11"){
            back.setBackgroundResource(R.drawable.lab_7)
            if(ivMap.isVisible){
                newScene(R.drawable.lab_7, text[7], "lab_7", R.drawable.map_lab_7)
            }
            else{
                mainAccentMusic.start()
                newScene(R.drawable.lab_7, text[14], "lab_7", R.drawable.map_lab_7)
                ivMap.isVisible = true
            }
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "black"){
            newScene(R.drawable.lab_11, text[14], "lab_11", R.drawable.map_lab_11)
        }

        else if(view.id == R.id.rbAnswer4 && backImage == "lab_7"){
            newScene(R.drawable.lab_1, text[14], "lab_1", R.drawable.map_lab_1)
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_1"){
            if(ivMap.isVisible){
                newScene(R.drawable.lab_7, text[7], "lab_7", R.drawable.map_lab_7)
            }
            else{
                mainAccentMusic.start()
                newScene(R.drawable.lab_7, text[5], "lab_7", R.drawable.map_lab_7)
                ivMap.isVisible = true
            }
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_7"){
            newScene(R.drawable.lab_11, text[14], "lab_11", R.drawable.map_lab_11)
        }

        else if(view.id == R.id.rbAnswer3 && backImage == "lab_5"){
            newScene(R.drawable.lab_8, text[14], "lab_8", R.drawable.map_lab_8)
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_5"){
            newScene(R.drawable.lab_11, text[14], "lab_11", R.drawable.map_lab_11)
        }
        else if(view.id == R.id.rbAnswer1 && backImage == "lab_5"){
            newScene(R.drawable.lab_2, text[8], "lab_2", R.drawable.map_lab_2)
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_2"){
            newScene(R.drawable.lab_5, text[14], "lab_5", R.drawable.map_lab_5)
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_8"){
            newScene(R.drawable.lab_5, text[14], "lab_5", R.drawable.map_lab_5)
        }

        else if(view.id == R.id.rbAnswer3 && backImage == "lab_8"){
            if(ivAccessCard.isVisible){
                newScene(R.drawable.lab_9, text[7], "lab_9", R.drawable.map_lab_9)
            }
            else{
                mainAccentMusic.start()
                newScene(R.drawable.lab_9, text[12], "lab_9", R.drawable.map_lab_9)
                ivAccessCard.isVisible = true
            }
        }
        else if(view.id == R.id.rbAnswer1 && backImage == "lab_8"){
            newScene(R.drawable.lab_4, text[8], "lab_4", R.drawable.map_lab_4)
        }
        else if(view.id == R.id.rbAnswer2 && backImage == "lab_8"){
            if(!ivAccessCard.isVisible){
                newScene(R.drawable.lab_6, text[11], "lab_6", R.drawable.map_lab_6)
            }
            else{
                newScene(R.drawable.lab_6_free, text[13], "lab_6_free", R.drawable.map_lab_6)
                mainAccentMusic = MediaPlayer.create(this, R.raw.acces_card_open_door)
                mainAccentMusic.start()
                rbGroup.isVisible = false
                ivMap.isVisible = false
                ivAccessCard.isVisible = false
                ivFlashlight.isVisible = false
            }
        }

        else if(view.id == R.id.rbAnswer4 && backImage == "lab_4"){
            newScene(R.drawable.lab_8, text[14], "lab_8", R.drawable.map_lab_8)
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_6"){
            newScene(R.drawable.lab_8, text[14], "lab_8", R.drawable.map_lab_8)
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_9"){
            newScene(R.drawable.lab_8, text[14], "lab_8", R.drawable.map_lab_8)
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_11"){
            newScene(R.drawable.lab_11, text[15], "lab_11", R.drawable.map_lab_11)
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_5"){
            newScene(R.drawable.lab_5, text[15], "lab_5", R.drawable.map_lab_5)
            tvText.text = text[15]
            ivMap.setImageResource(R.drawable.map_lab_5)
        }
        if(backImage == "lab_10"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_10)
        }
        if(backImage == "lab_6"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_6)
        }
        if(backImage == "lab_3"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_3)
        }
        if(backImage == "lab_9"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_9)
        }
        if(backImage == "lab_4"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_4)
        }
        if(backImage == "lab_7"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_7)
        }
        if(backImage == "lab_2"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
            ivMap.setImageResource(R.drawable.map_lab_2)
        }
    }
    fun tvTextClick(view : View){
        if(tvText.text == text[0]){
            tvText.text = text[1]

        }
        else if(tvText.text == text[1]){
            tvText.text = text[2]

        }
        else if(tvText.text == text[2]){
            tvText.text = text[3]

        }
        else if(tvText.text == text[3]){
            tvText.text = text[4]
            back.setBackgroundResource(R.drawable.lab_7)
        }
        else if(tvText.text == text[4]){
            tvText.text = text[5]
            back.setBackgroundResource(R.drawable.lab_11)
            ivMap.isVisible = true
            ivMap.setImageResource(R.drawable.map_lab_11)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Карта")
                .setMessage("Чтобы посмотреть свое местоположение нажмите на карту в левой части экрана")
                .setPositiveButton("ОК") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
            builder.show()
        }
        else if(tvText.text == text[5]){
            tvText.text = text[6]
            back.setBackgroundResource(R.drawable.lab_11)
            backImage = "lab_11"
        }
        else if(tvText.text == text[6]){
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true
            rbAnswer3.isVisible = true
            rbAnswer4.isVisible = true
            rbGroup.isVisible = true
        }
        else if(backImage == "lab_6_free"){
            back.setBackgroundResource(R.drawable.end)
            backImage = "end"
            ivMap.isVisible = false
            ivAccessCard.isVisible = false
            ivFlashlight.isVisible = false
            imgAvatar.isVisible = false
            tvText.isVisible = false
            rbGroup.isVisible = false
        }
    }
    fun backClick(view: View) {
        try{
            if(backImage == "end"){
                var intent : Intent = Intent(this@Story2Activity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        catch(e : Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
    fun ivButtonMainMenuClick(view : View){
        var intent : Intent = Intent(this@Story2Activity, MainActivity::class.java)
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