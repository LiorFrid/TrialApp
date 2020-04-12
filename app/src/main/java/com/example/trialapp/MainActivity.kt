package com.example.trialapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<Button>(R.id.signinBtn)
        val regigsterBtn = findViewById<TextView>(R.id.regBtn)
        loginBtn.setOnClickListener{this.loginBtnClicked()}
        regigsterBtn.setOnClickListener{this.registerBtnClicked()}
    }
    private fun loginBtnClicked(){
            //should login
    }
    private fun registerBtnClicked(){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}
