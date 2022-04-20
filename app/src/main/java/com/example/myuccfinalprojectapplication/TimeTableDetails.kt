package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class TimeTableDetails : AppCompatActivity() {
    private lateinit var abtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table_details)


        //back button
        abtn = findViewById(R.id.abtn)
        abtn.setOnClickListener{
            val intent = Intent(this, Timetable::class.java)
            startActivity(intent)
        }

        //Gets value sent from Timetable activity
        val index: String? = this.intent.getStringExtra("listIndex1")

        //Creates objects for each activity element
        val day: TextView = findViewById(R.id.tvDay)
        val course: TextView = findViewById(R.id.tvCourses)
        val time: TextView = findViewById(R.id.tvTime)

        //Assigns value to elements according to retrieved index
        when (index) {
            "0" -> {
                day.text = "Monday"
                course.text = "Programming Design Using Java"
                time.text = "6:00pm - 8:00pm"

            }
            "1" -> {
                day.text = "Sunday"
                course.text = "Database Management Systems I"
                time.text = "12:00pm - 2:00pm"
            }
            "2" -> {
                day.text = "Sunday"
                course.text = "Internet Authoring I"
                time.text = "7:00am - 9:00am"
            }
            "3" -> {
                day.text = "Tuesday"
                course.text = "Data Communications & Networks II"
                time.text = "8:00pm - 10:00pm"
            }
            "4" -> {
                day.text = "Wednesday"
                course.text = "Computer Essentials & Troubleshooting"
                time.text = "6:00pm - 8:00pm"

            }
            "5" -> {
                day.text = "Wednesday"
                course.text = "Project +"
                time.text = "8:00pm - 10:00pm"

            }
            "6" -> {
                day.text = "Thursday"
                course.text = "Mobile Application Development"
                time.text = "6:00pm - 8:00pm"
            }
            "7" -> {
                day.text = "Friday"
                course.text = "Internet Authoring II"
                time.text = "8:00pm - 10:00pm"
            }
            "8" -> {
                day.text = "Saturday"
                course.text = "Database Management Systems II"
                time.text = "8:00pm - 10:00pm"
            }
            "9" -> {
                day.text = "Monday"
                course.text = "Programming Techniques"
                time.text = "2:00pm - 4:00pm"
            }
        }
    }
        }

