package com.example.task_1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.RadioButton
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dropdown_list.*
import kotlinx.android.synthetic.main.view_entries.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val qualification = resources.getStringArray(R.array.qualification_list)

        var arrayAdapter = ArrayAdapter(this, R.layout.dropdown_list, qualification)
        autoComplete_dropdown.setAdapter(arrayAdapter)
    }

    override fun onResume() {
        super.onResume()

        val database =
            Room.databaseBuilder(applicationContext, UsersDatabase::class.java, "UsersDB").build()

//        database.usersDAO().deleteallEntries()

        btn_viewEntries.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }

        btn_submit.setOnClickListener {
            println("Name =>> ${swtich_job.isChecked}")
            if (form_isValid()) {
                saveDetails()
            }
        }
    }

    fun form_isValid(): Boolean {

        if (text_name.text.toString().length < 1) {
            text_name.setError("Name is required")
            return false
        }
        text_name.setError(null)
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(text_email.text.toString())
                .matches() == false
        ) {
            text_email.setError("Enter a valid email")
            return false
        }
        text_email.setError(null)
        val selectedid = radio_group.checkedRadioButtonId
        if (selectedid == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    fun saveDetails() {
        val name = text_name.text.toString()
        val email = text_email.text.toString()
        val selectedid = radio_group.checkedRadioButtonId
        val selectedgender: RadioButton = findViewById<View>(selectedid) as RadioButton
        val stream = autoComplete_dropdown.text.toString()
        val emp_type: String
        if (swtich_job.isChecked == false)
            emp_type = "FUll Time"
        else
            emp_type = "Half Time"

        val database =
            Room.databaseBuilder(applicationContext, UsersDatabase::class.java, "UsersDB").build()

        GlobalScope.launch {
            database.usersDAO().insertUser(
                Users
                    (0, "$name", "$email", "${selectedgender.text}", "$stream", "$emp_type")
            )
        }
    }
}