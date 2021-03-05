package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val topanimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomanimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        imgview.startAnimation(topanimation)
        textview.startAnimation(bottomanimation)

        Handler().postDelayed({
            startActivity(Intent(this, loginActivity::class.java))
        }, 4000);



    }
}