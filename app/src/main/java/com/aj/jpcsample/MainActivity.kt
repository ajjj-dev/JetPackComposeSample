package com.aj.jpcsample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aj.jpcsample.jpc.HappyBirthdayActivity
import com.aj.jpcsample.jpc.JpcTutorialActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnHappyBirthdayActivity = findViewById<Button>(R.id.btn_happy_birthday_activity)
        val btnJpcTutorialActivity = findViewById<Button>(R.id.btn_jpc_tutorial_activity)

        btnHappyBirthdayActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    HappyBirthdayActivity::class.java
                )
            )
        }

        btnJpcTutorialActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    JpcTutorialActivity::class.java
                )
            )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}