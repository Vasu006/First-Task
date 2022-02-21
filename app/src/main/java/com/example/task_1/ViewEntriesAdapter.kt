package com.example.task_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_entries.view.*

class ViewEntriesAdapter(
    var users : List<Users>
) : RecyclerView.Adapter<ViewEntriesAdapter.ViewEntriesHolder>()
{
    inner class ViewEntriesHolder (viewEntries : View) : RecyclerView.ViewHolder(viewEntries)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewEntriesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_entries,parent,false)
        return ViewEntriesHolder(view)
    }

    override fun onBindViewHolder(holder: ViewEntriesHolder, position: Int) {
        holder.itemView.apply {
            name_second.text = "Name : ${users[position].name}"
            email_second.text = "Email : ${users[position].email}"
            gender_second.text = "Gender : ${users[position].gender}"
            jobType_second.text = "Job : ${users[position].emp_type}"
            qualification_second.text = "Qualification : ${users[position].stream}"
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}