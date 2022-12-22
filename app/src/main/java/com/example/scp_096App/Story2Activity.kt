package com.example.scp_096App

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_story2.*
import java.io.BufferedReader
import java.io.InputStreamReader

class Story2Activity : AppCompatActivity() {
    lateinit var mainSplashMusic : MediaPlayer
    lateinit var text : List<String>
    var firstClickMap : Boolean = true
    var firstClickFlashlight : Boolean = true
    var firstClickAccessCard : Boolean = true
    var backImage : String = "lab_7"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story2)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));

        mainSplashMusic = MediaPlayer.create(this, R.raw.main_theme)
        if(!mainSplashMusic.isPlaying)
            mainSplashMusic.start()

        mainSplashMusic.isLooping = true

        val reader = BufferedReader(InputStreamReader(this.assets.open("story2_text.txt"), "windows-1251"))
        text = reader.readLines()
        tvText.text = text[0]
        rbAnswer1.text = getString(R.string.left)
        rbAnswer2.text = getString(R.string.right)
        rbAnswer3.text = getString(R.string.straight)
        rbAnswer4.text = getString(R.string.back)
    }

    fun ivMapClick(view : View){
        if(firstClickMap){
            ivMaterial.isVisible = true
            ivMaterial.setImageResource(R.drawable.map)
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
    fun radioButtonClick(view : View){
        rbAnswer1.isVisible = true
        rbAnswer2.isVisible = true
        var button : RadioButton = findViewById(view.id)
        if(view.id == R.id.rbAnswer2 && backImage == "lab_11"){
            back.setBackgroundResource(R.drawable.lab_10)
            tvText.text = text[14]
            backImage = "lab_10"
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_10"){
            back.setBackgroundResource(R.drawable.lab_3)
            tvText.text = text[10]
            backImage = "lab_3"
            ivFlashlight.isVisible = true
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_3"){
            back.setBackgroundResource(R.drawable.lab_10)
            tvText.text = text[14]
            backImage = "lab_10"
        }

        else if(view.id == R.id.rbAnswer4  && backImage == "lab_10"){
            back.setBackgroundResource(R.drawable.lab_11)
            tvText.text = text[14]
            backImage = "lab_11"
        }

        else if(view.id == R.id.rbAnswer1 && backImage == "lab_11"){
            if(ivFlashlight.isVisible){
                back.setBackgroundResource(R.drawable.lab_5)
                tvText.text = text[14]
                backImage = "lab_5"
            }
           else{
                back.setBackgroundResource(R.drawable.black_image)
                tvText.text = text[9]
                backImage = "black"
            }
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_11"){
            back.setBackgroundResource(R.drawable.lab_7)
            tvText.text = text[14]
            backImage = "lab_7"
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "black"){
            back.setBackgroundResource(R.drawable.lab_11)
            tvText.text = text[14]
            backImage = "lab_11"
        }

        else if(view.id == R.id.rbAnswer4 && backImage == "lab_7"){
            back.setBackgroundResource(R.drawable.lab_1)
            tvText.text = text[14]
            backImage = "lab_1"
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_1"){
            back.setBackgroundResource(R.drawable.lab_7)
            tvText.text = text[14]
            backImage = "lab_7"
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_7"){
            back.setBackgroundResource(R.drawable.lab_11)
            tvText.text = text[14]
            backImage = "lab_11"
        }

        else if(view.id == R.id.rbAnswer3 && backImage == "lab_5"){
            back.setBackgroundResource(R.drawable.lab_8)
            tvText.text = text[14]
            backImage = "lab_8"
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_5"){
            back.setBackgroundResource(R.drawable.lab_11)
            tvText.text = text[14]
            backImage = "lab_11"
        }
        else if(view.id == R.id.rbAnswer1 && backImage == "lab_5"){
            back.setBackgroundResource(R.drawable.lab_2)
            tvText.text = text[7]
            backImage = "lab_2"
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_2"){
            back.setBackgroundResource(R.drawable.lab_5)
            tvText.text = text[14]
            backImage = "lab_5"
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_8"){
            back.setBackgroundResource(R.drawable.lab_5)
            tvText.text = text[14]
            backImage = "lab_5"
        }

        else if(view.id == R.id.rbAnswer3 && backImage == "lab_8"){
            back.setBackgroundResource(R.drawable.lab_9)
            tvText.text = text[12]
            backImage = "lab_9"
            ivAccessCard.isVisible = true
        }
        else if(view.id == R.id.rbAnswer1 && backImage == "lab_8"){
            back.setBackgroundResource(R.drawable.lab_4)
            tvText.text = text[7]
            backImage = "lab_4"
        }
        else if(view.id == R.id.rbAnswer2 && backImage == "lab_8"){
            if(!ivAccessCard.isVisible){
                back.setBackgroundResource(R.drawable.lab_6)
                tvText.text = text[11]
                backImage = "lab_6"
            }
            else{
                back.setBackgroundResource(R.drawable.lab_6)
                tvText.text = text[13]
                backImage = "lab_6_free"
            }
        }

        else if(view.id == R.id.rbAnswer4 && backImage == "lab_4"){
            back.setBackgroundResource(R.drawable.lab_8)
            tvText.text = text[14]
            backImage = "lab_8"
        }
        else if(view.id == R.id.rbAnswer4 && backImage == "lab_6"){
            back.setBackgroundResource(R.drawable.lab_8)
            tvText.text = text[14]
            backImage = "lab_8"
        }

        else if(view.id == R.id.rbAnswer4 && backImage == "lab_9"){
            back.setBackgroundResource(R.drawable.lab_8)
            tvText.text = text[14]
            backImage = "lab_8"

        }
        else if(backImage == "lab_6_free"){

        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_11"){
            tvText.text = text[15]
        }
        else if(view.id == R.id.rbAnswer3 && backImage == "lab_5"){
            tvText.text = text[15]
        }
        if(backImage == "lab_10"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        if(backImage == "lab_3"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
        }
        if(backImage == "lab_9"){
            rbAnswer1.isVisible = false
            rbAnswer2.isVisible = false
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
        }
        else if(tvText.text == text[5]){
            tvText.text = text[6]
            back.setBackgroundResource(R.drawable.lab_11)
            ivMap.isVisible = true
            backImage = "lab_11"
        }
        else if(tvText.text == text[6]){
            rbAnswer1.isVisible = true
            rbAnswer2.isVisible = true
            rbAnswer3.isVisible = true
            rbAnswer4.isVisible = true
            rbGroup.isVisible = true
        }
    }
}