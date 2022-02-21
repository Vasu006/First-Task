package com.example.task_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.view_entries.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val database = Room.databaseBuilder(applicationContext, UsersDatabase :: class.java, "UsersDB").allowMainThreadQueries().build()

        var userList : List<Users>
        userList = database.usersDAO().getUsers()
        val adapter = ViewEntriesAdapter(userList)
        RVsecond.adapter = adapter
        RVsecond.layoutManager = LinearLayoutManager(this)
    }
}