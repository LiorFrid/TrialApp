package com.example.trialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        val signUpBtn = findViewById<Button>(R.id.signupBtn)
        signUpBtn.setOnClickListener{signUpBtnClicked()}
    }

    private fun signUpBtnClicked() {
        val mail = findViewById<TextView>(R.id.emailRegTxt).text.toString()
        val pass = findViewById<TextView>(R.id.passRegTxt).text.toString()
        auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener {
            val int = Intent(this, MainActivity::class.java )
            startActivity(int)
        }
    }
}
