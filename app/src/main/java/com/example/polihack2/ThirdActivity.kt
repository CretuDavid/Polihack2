package com.example.polihack2

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        theme.applyStyle(R.style.AppTheme, true)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main3)
        val buttonmainmenu = findViewById(R.id.mainmenu) as Button
        buttonmainmenu.setOnClickListener(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}