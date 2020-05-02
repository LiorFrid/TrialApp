package com.example.trialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        val EmailTextFill = findViewById<TextView>(R.id.Email)
        val PasswordTextFill = findViewById<TextView>(R.id.Password)
        val LoginBtn = findViewById<Button>(R.id.LoginBtn)
        val RegisterText: TextView = findViewById<TextView>(R.id.registerText)
        EmailTextFill.setOnClickListener { EmailTextFill.text = "" }

        PasswordTextFill.setOnClickListener { PasswordTextFill.text = "" }
        //startActivity(Intent(this, LandingScreen::class.java))
        LoginBtn.setOnClickListener { this.loginBtnClicked() }
        RegisterText.setOnClickListener { RegisterTextClicked() }

    }

    private fun loginBtnClicked() {
        val EmailTextFill = findViewById<TextView>(R.id.Email)
        val PasswordTextFill = findViewById<TextView>(R.id.Password)
        val LoginBtn = findViewById<Button>(R.id.LoginBtn)
        val RegisterText: TextView = findViewById<TextView>(R.id.registerText)
        auth = FirebaseAuth.getInstance()
        if (!EmailTextFill.text.isEmpty() && !PasswordTextFill.text.isEmpty()) {
            auth.signInWithEmailAndPassword(
                EmailTextFill.text.toString(),
                PasswordTextFill.text.toString()
            ).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, LandingScreen::class.java))
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

        //should login

        private fun RegisterTextClicked() {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

