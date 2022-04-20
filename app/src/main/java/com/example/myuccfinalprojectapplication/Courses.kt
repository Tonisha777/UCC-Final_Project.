package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.core.view.View

class Courses : AppCompatActivity() {

    private lateinit var courseList: ArrayList<CourseModel>
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var tvData: TextView
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)


        ///Action bar
        val actionBar = supportActionBar

        //actionbar title
        actionBar!!.title = "UCC Spring Courses"

        //back button
        val bkbtn: Button = findViewById(R.id.bkbtn)
        bkbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val insertbtn: Button = findViewById(R.id.insertbtn)
        insertbtn.setOnClickListener {
            val intent = Intent(this, Data::class.java)
            startActivity(intent)
        }


        courseRecyclerView = findViewById(R.id.rvCourses)
        courseRecyclerView.layoutManager = LinearLayoutManager(this)
        courseRecyclerView.setHasFixedSize(true)
        tvData = findViewById(R.id.tvData)

        courseList = arrayListOf<CourseModel>()

        getCourseData()

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getCourseData(){
        courseRecyclerView.visibility = android.view.View.GONE
        tvData.visibility = android.view.View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Courses")

        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                courseList.clear()
                if(snapshot.exists()){
                    for(courseSnap in snapshot.children){
                        val courseData = courseSnap.getValue(CourseModel::class.java)
                        courseList.add(courseData!!)
                    }
                    val mAdapter = CourseAdapter(courseList)
                    courseRecyclerView.adapter = mAdapter

                    courseRecyclerView.visibility = android.view.View.VISIBLE
                    tvData.visibility = android.view.View.GONE


                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

}


