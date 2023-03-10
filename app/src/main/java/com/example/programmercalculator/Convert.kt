package com.example.programmercalculator

object Convert {

    fun binaryToDecimal(value: Int) = Integer.parseInt(value.toString(), 2).toString()
    fun binaryToOctal(value: Int) = Integer.toOctalString(binaryToDecimal(value).toInt())
    fun binaryToHexadecimal(value: Int) = Integer.toHexString(binaryToDecimal(value).toInt()).uppercase()


    fun decimalToBinary(value: Int) = Integer.toBinaryString(value).toString()
    fun decimalToOctal(value: Int) = Integer.toOctalString(value).toString()
    fun decimalToHexadecimal(value: Int) = Integer.toHexString(value).uppercase()


    fun octalToBinary(value: Int) = Integer.toBinaryString(octalToDecimal(value).toInt()).toString()
    fun octalToDecimal(value: Int) = Integer.parseInt(value.toString(), 8).toString()
    fun octalToHexadecimal(value: Int) = Integer.toHexString(octalToDecimal(value).toInt()).toString().uppercase()


    fun hexadecimalToBinary(value: String) = Integer.toBinaryString(hexadecimalToDecimal(value).toInt())
    fun hexadecimalToDecimal(value: String) = Integer.parseInt(value, 16).toString()
    fun hexadecimalToOctal(value: String) = Integer.toOctalString(hexadecimalToDecimal(value).toInt())
}