package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class Data : AppCompatActivity() {

    private lateinit var etcode: EditText
    private lateinit var etname: EditText
    private lateinit var etcredits: EditText
    private lateinit var etprerequistes: EditText
    private lateinit var etdesc: EditText
    private lateinit var insertbtn: Button
    private lateinit var bbtn: Button
    private lateinit var fetchbtn: Button

    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        fetchbtn = findViewById(R.id.fetchbtn)
        fetchbtn.setOnClickListener {
            startActivity(Intent(this, Courses::class.java))
        }


        insertbtn = findViewById(R.id.insertbtn)
        insertbtn.setOnClickListener {
            saveCourseData()

        }

        etcode = findViewById(R.id.etcode)
        etname = findViewById(R.id.etname)
        etcredits = findViewById(R.id.etcredits)
        etprerequistes = findViewById(R.id.etprerequistes)
        etdesc = findViewById(R.id.etdesc)

        dbRef = FirebaseDatabase.getInstance().getReference("Courses")



        }
    private fun saveCourseData(){
        //getting values
        val code = etcode.text.toString()
        val name = etname.text.toString()
        val credits = etcredits.text.toString()
        val prerequistes = etprerequistes.text.toString()
        val desc = etdesc.text.toString()

        if(code.isEmpty()){
            etcode.error = "Please enter Course code"
        }
        if(name.isEmpty()){
            etname.error = "Please enter Course name"
        }
        if(credits.isEmpty()){
            etcredits.error = "Please enter Course credits"
        }
        if(prerequistes.isEmpty()){
            etprerequistes.error = "Please enter Course pre-requistes"
        }
        if(desc.isEmpty()){
            etdesc.error = "Please enter Course Description"
        }


        val courseid = dbRef.push().key!!

        val course = CourseModel(courseid, code, name, credits, prerequistes, desc)

        dbRef.child(courseid).setValue(course)
            .addOnCompleteListener{
                Toast.makeText(this, "All data is inserted successfully", Toast.LENGTH_LONG).show()

                etcode.text.clear()
                etname.text.clear()
                etcredits.text.clear()
                etprerequistes.text.clear()
                etdesc.text.clear()

            }.addOnFailureListener{err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
            }
    }

    }





