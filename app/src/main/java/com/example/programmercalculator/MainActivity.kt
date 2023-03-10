package com.example.programmercalculator

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resetButton: Button
    private lateinit var convert: Button
    private lateinit var editTextNumber: EditText
    private lateinit var textViewResult: TextView
    private lateinit var fromAutoCompleteTextView: AutoCompleteTextView
    private lateinit var toAutoCompleteTextView: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        resetButton = findViewById(R.id.reset_button)
        convert = findViewById(R.id.convert_button)
        editTextNumber = findViewById(R.id.editTextNumber)
        textViewResult = findViewById(R.id.textViewResult)
        fromAutoCompleteTextView = findViewById(R.id.fromAutoCompleteTextView)
        toAutoCompleteTextView = findViewById(R.id.toAutoCompleteTextView)
    }
}