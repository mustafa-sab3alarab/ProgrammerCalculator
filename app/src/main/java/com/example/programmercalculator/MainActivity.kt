package com.example.programmercalculator

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resetButton: Button
    private lateinit var convert: Button
    private lateinit var editTextNumber: EditText
    private lateinit var textViewResult: TextView
    private lateinit var fromAutoCompleteTextView: AutoCompleteTextView
    private lateinit var toAutoCompleteTextView: AutoCompleteTextView

    private var fromSelectedItem = 0
    private var toSelectedItem = 0

    private companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setupDropMenu()

        fromAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Log.d(TAG, "from menu item position: $position")
                fromSelectedItem = position
            }

        toAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Log.d(TAG, "to menu item position: $position")
                toSelectedItem = position
            }

        resetButton.setOnClickListener { clearInput() }

    }

    private fun initView() {
        resetButton = findViewById(R.id.reset_button)
        convert = findViewById(R.id.convert_button)
        editTextNumber = findViewById(R.id.editTextNumber)
        textViewResult = findViewById(R.id.textViewResult)
        fromAutoCompleteTextView = findViewById(R.id.fromAutoCompleteTextView)
        toAutoCompleteTextView = findViewById(R.id.toAutoCompleteTextView)
    }

    private fun setupDropMenu() {
        val items = arrayOf("Binary", "Decimal", "Octal", "Hexadecimal")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        fromAutoCompleteTextView.setAdapter(adapter)
        toAutoCompleteTextView.setAdapter(adapter)
    }

    private fun clearInput() {
        editTextNumber.text.clear()
        textViewResult.text = "0"
    }

}