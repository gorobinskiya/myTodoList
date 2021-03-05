package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_reg.*

class RegActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        auth = Firebase.auth



        regbtn.setOnClickListener {
        val email:String = editregmail.text.toString().trim()
        val password:String = editregpass.text.toString().trim()

        if (TextUtils.isEmpty(email)){
            editregmail.setError("email is required")
            return@setOnClickListener
        }
        if (TextUtils.isEmpty(password)){
            editregpass.setError("password is required")
            return@setOnClickListener
        }
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            startActivity(Intent(this, HomeActivity::class.java))
                            finish()
                        }
                        else{
                        Log.d("check error", "${task.isCanceled}, ${task.exception}")
                        }
                    }
    }
    }

}