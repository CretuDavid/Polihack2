package com.example.polihack2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent

val realpw="realpassword"
val realemail="realemail@gmail.com"

class SecondActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main2)
        val buttonlogin = findViewById(R.id.login_button) as Button
        var email = findViewById(R.id.email) as EditText
        var password = findViewById(R.id.password) as EditText
        buttonlogin.setOnClickListener{
            if(email.text.toString() == realemail && password.text.toString() == realpw){
                intent = Intent(this, ThirdActivity::class.java)
                startActivity(intent) }
            else{
                Toast.makeText(this@SecondActivity, "Wrong Password or Email", Toast.LENGTH_LONG).show()
            }
        }
    }
}