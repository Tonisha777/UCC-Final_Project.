package com.example.myuccfinalprojectapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class Timetable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetable)

        //Reads time table list from items in strings.xml file
        val timeList: Array<String> = resources.getStringArray(R.array.time)
        //Creates adapter that sets list type and list item
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timeList)

        val listView1: ListView = findViewById(R.id.lvTimeTable)
        //ListView control populated with list items
        listView1.adapter = adapter

        //Defines action when list item is clicked
        listView1.setOnItemClickListener { parent, view, position, id ->
            //Displays a message showing list item index
            Toast.makeText(this, "Clicked item : "+position, Toast.LENGTH_SHORT).show()
            //Specifies which activity should be launched
            val intent = Intent(this, TimeTableDetails::class.java)
            //Stores index number to be shared with Timetable Details activity
            intent.putExtra("listIndex1", position.toString())
            //Starts activity
            this.startActivity(intent)
        }

        ///Action bar
        val actionBar = supportActionBar

        //actionbar title
        actionBar!!.title = "UCC Spring Courses Timetable"

        //back button
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}