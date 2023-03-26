package com.example.kotlin_oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        radioGroup = findViewById(R.id.radio_group)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
                if(radio.text == "RED"){
                    Toast.makeText(this,"Right Answer", Toast.LENGTH_SHORT).show()
                }
            else
                {
                    Toast.makeText(this,"Wrong Answer", Toast.LENGTH_SHORT).show()
                }
        }
    }

//    fun radio_button_click(view: View) {
//        val radio: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
//        Toast.makeText(
//            applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT
//        ).show()
//    }
}