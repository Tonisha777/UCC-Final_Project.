package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton

class Media : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        ///Action bar
        val actionBar = supportActionBar

        //actionbar title
        actionBar!!.title = "UCC Social Media"

        //back button
            actionBar.setDisplayHomeAsUpEnabled(true)



        //Method launches Social2/IG activity
        val web2: ImageButton = findViewById(R.id.imgFacebook)
        web2.setOnClickListener {
            val intent = Intent(this, Social2::class.java)
            startActivity(intent)
        }
        //Method launches Social3/IG activity
        val web3: ImageButton = findViewById(R.id.imgTwitter)
        web3.setOnClickListener {
            val intent = Intent(this, Social3::class.java)
            startActivity(intent)
        }

        //Method launches Social/IG activity
        val web: ImageButton = findViewById(R.id.imgInstagram)
        web.setOnClickListener {
            val intent = Intent(this, Social::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
       onBackPressed()
        return true
    }
        }
