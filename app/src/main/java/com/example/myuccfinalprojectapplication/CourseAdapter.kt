package com.example.myuccfinalprojectapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter (private val courselist:ArrayList<CourseModel>):
    RecyclerView.Adapter<CourseAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCourse = courselist[position]
        holder.tvCode.text = currentCourse.code
        holder.tvCName.text = currentCourse.name
        holder.tvCCedits.text = currentCourse.credits
        holder.tvCPrerequistes.text = currentCourse.prerequistes
        holder.tvCDesc.text = currentCourse.desc
    }

    class ViewHolder(itemView:android.view.View):RecyclerView.ViewHolder(itemView) {

        val tvCode : TextView = itemView.findViewById(R.id.tvCourseCode)
        val tvCName : TextView = itemView.findViewById(R.id.tvCourseName)
        val tvCCedits : TextView = itemView.findViewById(R.id.tvCourseCredits)
        val tvCPrerequistes : TextView = itemView.findViewById(R.id.tvCoursePrerequistes)
        val tvCDesc : TextView = itemView.findViewById(R.id.tvCourseDesc)

    }

    override fun getItemCount(): Int {
       return courselist.size
    }


}