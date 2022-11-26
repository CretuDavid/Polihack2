package com.example.polihack2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.register_main)
    }

}