package com.example.myuccfinalprojectapplication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class Admissions : AppCompatActivity() {

    private lateinit var bbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        //back button
        bbtn = findViewById(R.id.bbtn)
        bbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Creates objects for each activity element
        val ad1: TextView = findViewById(R.id.tvAdmissions1)
        ad1.text = "To be unconditionally admitted to complete UCC undergraduate programmes, " +
                "individuals should possess a minimum of five (5) subjects at the GCE or CSEC level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, 3 respectively. " +
                "A CSEC pass at level 3 must have been obtained since 1998.\n" +
                "Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC subjects or can opt to do UCC replacement courses Core Mathematics, English for Academic Purpose and Fundamentals of Accounting.\n" +
                "Candidates can opt to apply under the Mature Entry option. " +
                "To be accepted, applicants must be working for 5 years or more and be at a minimum age of 25 years. " +
                "Academic qualifications, a detailed resume, a job letter and 3 professional references will be required.\n" +
                "---\n" +
                "\n" +
                "HONOURS PROGRAMME\n" +
                "Students with 8 CXC/GCE subjects including Mathematics and English Language at Grade 1 may be eligible for a 25% tuition waiver during the first year." +
                "---\n" +
                "\n" +
                "To apply visit this link: https://ucc.edu.jm/apply/"
    }


}