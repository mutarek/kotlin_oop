package com.example.kotlin_oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var floatingActionButton: FloatingActionButton
    lateinit var editText: EditText
    val users = mutableListOf(
        "Virat Kohli", "Rohit Sharma", "Steve Smith",
        "Kane Williamson", "Ross Taylor"
    )
    var userInput = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.sample_list)
        floatingActionButton = findViewById(R.id.floatingActionButton)
        editText = findViewById(R.id.et_Name)
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        listView.adapter = arrayAdapter

        floatingActionButton.setOnClickListener{
            userInput = editText.text.toString()
            if(userInput.isEmpty()){
                Toast.makeText(this,"Please select a name", Toast.LENGTH_SHORT).show()
            }
            else
            {
                users.add(0,userInput)
                arrayAdapter.notifyDataSetChanged()
            }
        }

        listView.setOnItemClickListener { parent, _, position, _ ->
            var data = parent.getItemIdAtPosition(position)
            Toast.makeText(this, "$data", Toast.LENGTH_SHORT).show()
            users.removeAt(data.toInt())
            arrayAdapter.notifyDataSetChanged()

        }
    }
}