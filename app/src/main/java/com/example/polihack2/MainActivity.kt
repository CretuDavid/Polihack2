package com.example.polihack2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        theme.applyStyle(R.style.AppTheme, true)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val buttonlogin = findViewById(R.id.buttonlogin) as Button
        buttonlogin.setOnClickListener{
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val themeswitch = findViewById(R.id.switchtheme) as Switch
        themeswitch.setOnCheckedChangeListener { _ , isChecked ->
            if(themeswitch.isChecked){
                theme.applyStyle(R.style.AppTheme, false)
                theme.applyStyle(R.style.AppThemeDark, true)

            }
        }
    }
}