package com.example.polihack2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MadsaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val buttonlogin = findViewById(R.id.buttonlogin) as Button
        buttonlogin.setOnClickListener{
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val buttonregister = findViewById(R.id.buttonregister) as Button
        buttonregister.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val themeswitch = findViewById(R.id.switchtheme) as Switch
        themeswitch.setOnCheckedChangeListener { _ , isChecked ->
            if(themeswitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}