package com.example.programmercalculator

object Converter {

    fun binaryToDecimal(value: Long): String {
        return try {
            Integer.parseInt(value.toString(), 2).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun binaryToOctal(value: Long): String {
        return try {
            Integer.toOctalString(binaryToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun binaryToHexadecimal(value: Long): String {
        return try {
            Integer.toHexString(binaryToDecimal(value).toInt()).uppercase()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }


    fun decimalToBinary(value: Long): String {
        return try {
            Integer.toBinaryString(value.toInt()).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun decimalToOctal(value: Long): String {
        return try {
            Integer.toOctalString(value.toInt()).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun decimalToHexadecimal(value: Long): String {
        return try {
            Integer.toHexString(value.toInt()).uppercase()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }


    fun octalToBinary(value: Long): String {
        return try {
            Integer.toBinaryString(octalToDecimal(value).toInt()).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun octalToDecimal(value: Long): String {
        return try {
            Integer.parseInt(value.toString(), 8).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun octalToHexadecimal(value: Long): String {
        return try {
            Integer.toHexString(octalToDecimal(value).toInt()).toString().uppercase()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }


    fun hexadecimalToBinary(value: String): String {
        return try {
            Integer.toBinaryString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun hexadecimalToDecimal(value: String): String {
        return try {
            Integer.parseInt(value, 16).toString()
        } catch (exception: NumberFormatException) {
            "0"
        }
    }

    fun hexadecimalToOctal(value: String): String {
        return try {
            Integer.toOctalString(hexadecimalToDecimal(value).toInt())
        } catch (exception: NumberFormatException) {
            "0"
        }
    }
}