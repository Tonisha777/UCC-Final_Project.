package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Media : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        //Method launches Social2/IG activity
        val web2: ImageButton = findViewById(R.id.imgFacebook)
        web2.setOnClickListener{
            val intent = Intent(this, Social2::class.java)
            startActivity(intent)
        }
        //Method launches Social3/IG activity
        val web3: ImageButton = findViewById(R.id.imgTwitter)
        web3.setOnClickListener{
            val intent = Intent(this, Social3::class.java)
            startActivity(intent)
        }

        //Method launches Social/IG activity
        val web: ImageButton = findViewById(R.id.imgInstagram)
        web.setOnClickListener{
            val intent = Intent(this, Social::class.java)
            startActivity(intent)
        }

        val backbtn: Button = findViewById(R.id.backbtn)
        backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}