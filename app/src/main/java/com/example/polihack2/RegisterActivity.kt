package com.example.polihack2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity: AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confpassword: EditText
    private lateinit var registerbutton: Button
    private lateinit var dbHandler: DBHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.register_main)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confpassword = findViewById(R.id.confpassword)
        registerbutton = findViewById(R.id.register_button)

        dbHandler = DBHandler(this@RegisterActivity)

        registerbutton.setOnClickListener(){
            val emailt = email.text.toString()
            val passwordt = password.text.toString()
            val confpasswordt = confpassword.text.toString()
            if(confpasswordt != passwordt){
                Toast.makeText(this@RegisterActivity, "Passwords are different!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            dbHandler.addNewCredentials(emailt, passwordt)
            Toast.makeText(this@RegisterActivity, "You have been registered!", Toast.LENGTH_LONG).show()
            email.setText("")
            password.setText("")
            confpassword.setText("")
        }
    }
}