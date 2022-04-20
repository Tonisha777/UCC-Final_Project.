package com.example.myuccfinalprojectapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Details : AppCompatActivity() {
    private lateinit var bACKbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //back button
        bACKbtn = findViewById(R.id.bACKbtn)
        bACKbtn.setOnClickListener{
            val intent = Intent(this, Directory::class.java)
            startActivity(intent)
        }

        //Gets value sent from Directory activity
        val index: String? = this.intent.getStringExtra("listIndex")

        //Creates objects for each activity element
        val name: TextView = findViewById(R.id.tvName)
        val email: TextView = findViewById(R.id.tvEmail)
        val photo: ImageView = findViewById(R.id.ivProfile)
        val phone: TextView = findViewById(R.id.tvPhone)

        //Assigns value to elements according to retrieved index
        when(index){
            "0" -> {
                name.text = "ROSE, Natalie"
                email.text = "ithod@ucc.edu.jm"
                phone.text = "6272819"
                photo.setImageResource(R.drawable.rose)
            }
            "1" -> {
                name.text = "DAVIDSON, Sonia"
                email.text = "businessadminhod@ucc.edu.jm"
                phone.text = "3564746"
                photo.setImageResource(R.drawable.davidson)
            }
            "2" -> {
                name.text = "AMONDE, Tom"
                email.text = "graduatestudiesdirector@ucc.edu.jm"
                phone.text = "6687753"
                photo.setImageResource(R.drawable.amonde)
            }
            "3" -> {
                name.text = "MILLER, Ionie"
                email.text = "appliedpsychologyfaculty@ucc.edu.jm"
                phone.text = "2635475"
                photo.setImageResource(R.drawable.miller)
            }
            "4" -> {
                name.text = "NDAJAH, Peter"
                email.text = "headofschoolsmathit@ucc.edu.jm"
                phone.text = "6473645"
                photo.setImageResource(R.drawable.ndajah)
            }
        }

    }

}