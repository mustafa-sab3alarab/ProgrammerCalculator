package com.example.programmercalculator

object Converter {

    fun binaryToDecimal(value: Int): String {
        try {
            return Integer.parseInt(value.toString(), 2).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun binaryToOctal(value: Int): String {
        try {
            return Integer.toOctalString(binaryToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun binaryToHexadecimal(value: Int): String {
        try {
            return Integer.toHexString(binaryToDecimal(value).toInt()).uppercase()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }


    fun decimalToBinary(value: Int): String {
        try {
            return Integer.toBinaryString(value).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun decimalToOctal(value: Int): String {
        try {
            return Integer.toOctalString(value).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }

    }

    fun decimalToHexadecimal(value: Int): String {
        try {
            return Integer.toHexString(value).uppercase()
        } catch (exception: NumberFormatException) {
            throw exception
        }

    }


    fun octalToBinary(value: Int): String {
        try {
            return Integer.toBinaryString(octalToDecimal(value).toInt()).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun octalToDecimal(value: Int): String {
        try {
            return Integer.parseInt(value.toString(), 8).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun octalToHexadecimal(value: Int): String {
        try {
            return Integer.toHexString(octalToDecimal(value).toInt()).toString().uppercase()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }


    fun hexadecimalToBinary(value: String): String {
        try {
            return Integer.toBinaryString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun hexadecimalToDecimal(value: String): String {
        try {
            return Integer.parseInt(value, 16).toString()
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }

    fun hexadecimalToOctal(value: String): String {
        try {
            return Integer.toOctalString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            throw exception
        }
    }
}