package com.example.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.content.ClipboardManager
import android.content.ClipData
import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var btn: Button
lateinit var resultTv: TextView
lateinit var input1: EditText
lateinit var input2: EditText
lateinit var btnnn: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button_gen)
        resultTv = findViewById(R.id.resultB)
        input1 = findViewById(R.id.txt_input_one)
        input2 = findViewById(R.id.txt_input_two)
        btnnn = findViewById(R.id.btn_pyco)


        fun generateRandomNumber(): Int {
            val input1 = input1.text.toString()
            val input2 = input2.text.toString()

            if (input1.isEmpty() || input2.isEmpty()) {
                return 0
            }

            if (input1 > input2) {
                return 0
            }


            val a: Int = input1.toInt()
            val b: Int = input2.toInt()
            return (a..b).random()
        }


        btn.setOnClickListener {
            resultTv.text = generateRandomNumber().toString()
        }


        btnnn.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = resultTv.text.toString()
            val clipData = ClipData.newPlainText("text", text)
            clipboardManager.setPrimaryClip(clipData)

        }


    }
}
