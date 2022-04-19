package com.example.myuccfinalprojectapplication


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val mail: String = "ithod@ucc.edu.jm"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creates directory object and links to button
        //Method launches Directory activity
        val directory: ImageButton = findViewById(R.id.ibDir)
        directory.setOnClickListener {
            val intent = Intent(this, Directory::class.java)
            startActivity(intent)
        }


        //Method to go to Media Activity
        val mediabtn: ImageButton = findViewById(R.id.ibSocials)
        mediabtn.setOnClickListener{
            val intent = Intent(this, Media::class.java)
            startActivity(intent)
        }

        //Method to go to Courses Activity
        val coursebtn: ImageButton = findViewById(R.id.ibCourses)
        coursebtn.setOnClickListener{
            val intent = Intent(this, Courses::class.java)
            startActivity(intent)
        }

        //Method to go to Admissions Activity
        val admission: ImageButton = findViewById(R.id.ibAdmission)
        admission.setOnClickListener {
            val intent = Intent(this, Admissions::class.java)
            startActivity(intent)
        }

        //Method to go to Time Table Activity
        val schedulebtn: ImageButton = findViewById(R.id.ibSchedule)
        schedulebtn.setOnClickListener{
            val intent = Intent(this, Timetable::class.java)
            startActivity(intent)
        }

        //Sends email to preset address when FAB is clicked
        val sendEmail: FloatingActionButton = findViewById(R.id.fabEmail)
        sendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", mail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, mail)
            startActivity(intent)
        }
    }
}