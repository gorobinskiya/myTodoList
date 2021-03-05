package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        textView.setOnClickListener {
            startActivity(Intent(this, RegActivity::class.java))
        }

        logbtn.setOnClickListener {
            val email:String = editlogmail.text.toString().trim()
            val password:String = editlogpass.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                editlogmail.setError("email is required")
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)){
                editlogpass.setError("password is required")
                return@setOnClickListener
            }
            auth.signInWithEmailAndPassword(email, password)
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
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

        }
    }






