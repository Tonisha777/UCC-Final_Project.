package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class Courses : AppCompatActivity() {

    private lateinit var courseList: ArrayList<CourseModel>
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var dbRef: DatabaseReference
    private lateinit var bkbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)


        //back button
        bkbtn= findViewById(R.id.bkbtn)
        bkbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        courseRecyclerView = findViewById(R.id.rvCourses)
        courseRecyclerView.layoutManager = LinearLayoutManager(this)
        courseRecyclerView.setHasFixedSize(true)


        courseList = arrayListOf<CourseModel>()

        getCourseData()

    }

    private fun getCourseData(){

        dbRef = FirebaseDatabase.getInstance().getReference("Courses")

        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(courseSnapshot in snapshot.children){
                        val courseData = courseSnapshot.getValue(CourseModel::class.java)
                        courseList.add(courseData!!)
                    }

                    courseRecyclerView.adapter = CourseAdapter(courseList)


                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

}


