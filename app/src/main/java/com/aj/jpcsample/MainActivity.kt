package com.aj.jpcsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aj.jpcsample.jpc.BusinessCardActivity
import com.aj.jpcsample.jpc.HappyBirthdayActivity
import com.aj.jpcsample.jpc.JpcTutorialActivity
import com.aj.jpcsample.jpc.MyComposeListActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize Views and set OnCLik listeners
        val btnHappyBirthdayActivity = findViewById<Button>(R.id.btn_happy_birthday_activity)
        val btnJpcTutorialActivity = findViewById<Button>(R.id.btn_jpc_tutorial_activity)
        val btnMyComposeListActivity = findViewById<Button>(R.id.btn_my_compose_list_activity)
        val btnBusinessCardActivity = findViewById<Button>(R.id.btn_business_card_activity)
        btnHappyBirthdayActivity.setOnClickListener(this)
        btnJpcTutorialActivity.setOnClickListener(this)
        btnMyComposeListActivity.setOnClickListener(this)
        btnBusinessCardActivity.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_happy_birthday_activity -> {
                navigateTo(HappyBirthdayActivity::class.java)
            }

            R.id.btn_jpc_tutorial_activity -> {
                navigateTo(JpcTutorialActivity::class.java)
            }

            R.id.btn_my_compose_list_activity -> {
                navigateTo(MyComposeListActivity::class.java)
            }
            R.id.btn_business_card_activity -> {
                navigateTo(BusinessCardActivity::class.java)
            }
        }
    }

    private fun navigateTo(clazz: Class<*>) {
        startActivity(Intent(this, clazz))
    }
}