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
        val EmailTextFill = findViewById<TextView>(R.id.Email)
        val PasswordTextFill = findViewById<TextView>(R.id.Password)
        val signUpBtn = findViewById<Button>(R.id.RegisterBtn)
        val backToLogin:TextView  = findViewById<TextView>(R.id.backToLogin)
        EmailTextFill.setOnClickListener{ EmailTextFill.text=""}
        PasswordTextFill.setOnClickListener{ PasswordTextFill.text=""}
        signUpBtn.setOnClickListener{signUpBtnClicked()}
        backToLogin.setOnClickListener{ backToLoginTextClicked()}

    }

    private fun signUpBtnClicked() {
        val mail = findViewById<TextView>(R.id.Email).text.toString()
        val pass = findViewById<TextView>(R.id.Password).text.toString()
        auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener {
            val int = Intent(this, MainActivity::class.java )
            startActivity(int)
        }
    }

    private fun backToLoginTextClicked(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}
