package com.example.polihack2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_main.*

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.register_main)

        register_button.setOnClickListener{

            val db = DBHelper(this, null)

            val email1 = email.text.toString()
            val password1 = password.text.toString()

            db.addcreds(email1, password1)
            Toast.makeText(this, "You have been registered", Toast.LENGTH_LONG).show()
        }
    }
}