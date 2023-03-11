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

        convertButton.setOnClickListener {
            val value = editTextNumber.text.toString()
            when {
                fromSelectedItem in 0..2 && checkInputValue(value, fromSelectedItem) &&
                        value.isNotEmpty() && value.isNotBlank() ->

                    textViewResult.text = convertNumber(value.toInt(), fromSelectedItem, toSelectedItem)

                fromSelectedItem == 3 && checkInputValue(value, fromSelectedItem) &&
                        value.isNotEmpty() && value.isNotBlank() ->

                    textViewResult.text = convertHexadecimal(value, fromSelectedItem, toSelectedItem)

                else -> {
                    Log.d(TAG, INVALID_NUMBER)
                    Toast.makeText(this, INVALID_NUMBER, Toast.LENGTH_SHORT).show()
                }
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
        val items = arrayOf("Binary", "Decimal", "Octal", "Hexadecimal")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
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
                value.toList().all { it in '0'..'9' }
            }
            3 -> {
                value.toList().all { it in '0'..'9' || it in 'A'..'F' }
            }
            else -> false
        }
    }

    private fun convertNumber(value: Int, pos1: Int, pos2: Int): String {
        Log.d(TAG, "${convertTableNumber(value)[pos1]?.get(pos2)}")
        return convertTableNumber(value)[pos1]?.get(pos2) ?: "0"
    }

    private fun convertHexadecimal(value: String, pos1: Int, pos2: Int): String {
        Log.d(TAG, "${convertTableHexadecimal(value)[pos1]?.get(pos2)}")
        return convertTableHexadecimal(value)[pos1]?.get(pos2) ?: "0"
    }

    private fun convertTableNumber(value: Int) = mapOf(
        0 to mapOf(
            0 to value.toString(),
            1 to Converter.binaryToDecimal(value),
            2 to Converter.binaryToOctal(value),
            3 to Converter.binaryToHexadecimal(value)
        ),
        1 to mapOf(
            0 to Converter.decimalToBinary(value),
            1 to value.toString(),
            2 to Converter.decimalToOctal(value),
            3 to Converter.decimalToHexadecimal(value)
        ),
        2 to mapOf(
            0 to Converter.octalToBinary(value),
            1 to Converter.octalToDecimal(value),
            2 to value.toString(),
            3 to Converter.octalToHexadecimal(value)
        )
    )

    private fun convertTableHexadecimal(value: String) = mapOf(
        3 to mapOf(
            0 to Converter.hexadecimalToBinary(value),
            1 to Converter.hexadecimalToDecimal(value),
            2 to Converter.hexadecimalToOctal(value),
            3 to value
        )
    )

}