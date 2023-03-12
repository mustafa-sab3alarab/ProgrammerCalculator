package com.example.programmercalculator

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resetButton: Button
    private lateinit var convertButton: Button
    private lateinit var editTextNumber: EditText
    private lateinit var textViewResult: TextView
    private lateinit var fromAutoCompleteTextView: AutoCompleteTextView
    private lateinit var toAutoCompleteTextView: AutoCompleteTextView

    private var fromSelectedItem = 0
    private var toSelectedItem = 0

    private val base = mapOf("Binary" to 2, "Octal" to 8, "Decimal" to 10, "Hexadecimal" to 16)

    private var fromBase = 2
    private var toBase = 2

    private companion object {
        const val TAG = "MainActivity"
        const val INVALID_NUMBER = "Invalid Number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setupDropMenu()

        fromAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                Log.d(TAG, "from menu item position: $position")
                fromSelectedItem = position
                fromBase = base[parent?.getItemAtPosition(position).toString()]!!
            }

        toAutoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                Log.d(TAG, "to menu item position: $position")
                toSelectedItem = position
                toBase = base[parent?.getItemAtPosition(position).toString()]!!
            }

        resetButton.setOnClickListener { clearInput() }

        convertButton.setOnClickListener {
            val value = editTextNumber.text.toString()

            if (checkInputValue(value, fromSelectedItem) && value.isNotEmpty() && value.isNotBlank())
                textViewResult.text = try {
                    convert(value, fromBase, toBase)
                } catch (e: NumberFormatException) {
                    "-1"
                }

            else {
                Log.d(TAG, INVALID_NUMBER)
                Toast.makeText(this, INVALID_NUMBER, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initView() {
        resetButton = findViewById(R.id.reset_button)
        convertButton = findViewById(R.id.convert_button)
        editTextNumber = findViewById(R.id.editTextNumber)
        textViewResult = findViewById(R.id.textViewResult)
        fromAutoCompleteTextView = findViewById(R.id.fromAutoCompleteTextView)
        toAutoCompleteTextView = findViewById(R.id.toAutoCompleteTextView)
    }

    private fun setupDropMenu() {
        val adapter = ArrayAdapter(this, R.layout.list_item, base.keys.toList())
        fromAutoCompleteTextView.setAdapter(adapter)
        toAutoCompleteTextView.setAdapter(adapter)
    }

    private fun clearInput() {
        editTextNumber.text.clear()
        textViewResult.text = "0"
    }

    private fun checkInputValue(value: String, itemSelected: Int): Boolean {
        return when (itemSelected) {
            0 -> {
                value.toList().all { it in '0'..'1' }
            }
            1 -> {
                value.toList().all { it in '0'..'9' }
            }
            2 -> {
                value.toList().all { it in '0'..'7' }
            }
            3 -> {
                value.toList().all { it in '0'..'9' || it in 'A'..'F' || it in 'a'..'f' }
            }
            else -> false
        }
    }

    private fun convert(value: String, from: Int, to: Int): String {
        return value.toLong(from).toString(to).uppercase()
    }

}