package com.example.programmercalculator

import android.util.Log

object Converter {

    fun binaryToDecimal(value: Long): String {
        try {
            return Integer.parseInt(value.toString(), 2).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C1", exception.message.toString())
        }
        return "0"
    }

    fun binaryToOctal(value: Long): String {
        try {
            return Integer.toOctalString(binaryToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            Log.e("C2", exception.message.toString())
        }
        return "0"
    }

    fun binaryToHexadecimal(value: Long): String {
        try {
            return Integer.toHexString(binaryToDecimal(value).toInt()).uppercase()
        } catch (exception: NumberFormatException) {
            Log.e("C3", exception.message.toString())
        }
        return "0"
    }


    fun decimalToBinary(value: Long): String {
        try {
            return Integer.toBinaryString(value.toInt()).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C4", exception.message.toString())
        }
        return "0"
    }

    fun decimalToOctal(value: Long): String {
        try {
            return Integer.toOctalString(value.toInt()).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C5", exception.message.toString())
        }
        return "0"

    }

    fun decimalToHexadecimal(value: Long): String {
        try {
            return Integer.toHexString(value.toInt()).uppercase()
        } catch (exception: NumberFormatException) {
            Log.e("C6", exception.message.toString())
        }
        return "0"

    }


    fun octalToBinary(value: Long): String {
        try {
            return Integer.toBinaryString(octalToDecimal(value).toInt()).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C7", exception.message.toString())
        }
        return "0"
    }

    fun octalToDecimal(value: Long): String {
        try {
            return Integer.parseInt(value.toString(), 8).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C8", exception.message.toString())
        }
        return "0"
    }

    fun octalToHexadecimal(value: Long): String {
        try {
            return Integer.toHexString(octalToDecimal(value).toInt()).toString().uppercase()
        } catch (exception: NumberFormatException) {
            Log.e("C9", exception.message.toString())
        }
        return "0"
    }


    fun hexadecimalToBinary(value: String): String {
        try {
            return Integer.toBinaryString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            Log.e("C10", exception.message.toString())
        }
        return "0"
    }

    fun hexadecimalToDecimal(value: String): String {
        try {
            return Integer.parseInt(value, 16).toString()
        } catch (exception: NumberFormatException) {
            Log.e("C11", exception.message.toString())
        }
        return "0"
    }

    fun hexadecimalToOctal(value: String): String {
        try {
            return Integer.toOctalString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            Log.e("C12", exception.message.toString())
        }
        return "0"
    }
}