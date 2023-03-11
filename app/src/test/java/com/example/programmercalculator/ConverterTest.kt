package com.example.programmercalculator

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.function.Executable

internal class ConverterTest {

    @Test
    fun `should return a convert number between binary and decimal when the data is valid`() {
        // given a valid binary number
        val value = 11011011L
        // when
        val result = Converter.binaryToDecimal(value)
        // then
        val expected = "219"
        assertEquals(expected, result)
    }


    @Test
    fun `should return zero when convert binary number to decimal with invalid data`() {
        // given a valid binary number
        val value = 2L
        // when
        val result =  Converter.binaryToDecimal(value)
        // then
        assertEquals("0", result)
    }

    @Test
    fun `should return a convert number between binary and octal when the data is valid`() {
        // given
        val value = 1011L
        // when
        val result = Converter.binaryToOctal(value)
        // then
        val expected = "13"
        assertEquals(expected, result)
    }


    @Test
    fun `should return zero when convert binary number to octal with invalid data`() {
        // given
        val value = 103L
        // when
        val result = Converter.binaryToOctal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between binary and hexadecimal when the data is valid`() {
        // given
        val value = 1011L
        // when
        val result = Converter.binaryToHexadecimal(value)
        // then
        val expected = "B"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert binary number to hexadecimal with invalid data`() {
        // given
        val value = 12L
        // when
        val result = Converter.binaryToHexadecimal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between decimal and binary when the data is valid`() {
        // given
        val value = 49995L
        // when
        val result = Converter.decimalToBinary(value)
        // then
        val expected = "1100001101001011"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between decimal and octal when the data is valid`() {
        // given
        val value = 12L
        // when
        val result = Converter.decimalToOctal(value)
        // then
        val expected = "14"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between decimal and hexadecimal when the data is valid`() {
        // given
        val value = 12L
        // when
        val result = Converter.decimalToHexadecimal(value)
        // then
        val expected = "C"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between octal and binary when the data is valid`() {
        // given
        val value = 12L
        // when
        val result = Converter.octalToBinary(value)
        // then
        val expected = "1010"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert octal number to binary with invalid data`() {
        // given
        val value = 8L
        // when
        val result = Converter.octalToBinary(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between octal and decimal when the data is valid`() {
        // given
        val value = 12L
        // when
        val result = Converter.octalToDecimal(value)
        // then
        val expected = "10"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert octal number to decimal with invalid data`() {
        // given
        val value = 8L
        // when
        val result = Converter.octalToDecimal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between octal and hexadecimal when the data is valid`() {
        // given
        val value = 12L
        // when
        val result = Converter.octalToHexadecimal(value)
        // then
        val expected = "A"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert octal number to hexadecimal with invalid data`() {
        // given
        val value = 9L
        // when
        val result = Converter.octalToHexadecimal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between hexadecimal and binary when the data is valid`() {
        // given
        val value = "AF"
        // when
        val result = Converter.hexadecimalToBinary(value)
        // then
        val expected = "10101111"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert hexadecimal number to binary with invalid data`() {
        // given
        val value = "g1d"
        // when
        val result = Converter.hexadecimalToBinary(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between hexadecimal and decimal when the data is valid`() {
        // given
        val value = "AF"
        // when
        val result = Converter.hexadecimalToDecimal(value)
        // then
        val expected = "175"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert hexadecimal number to decimal with invalid data`() {
        // given
        val value = "A1gd"
        // when
        val result = Converter.hexadecimalToDecimal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }

    @Test
    fun `should return a convert number between hexadecimal and octal when the data is valid`() {
        // given
        val value = "AF"
        // when
        val result = Converter.hexadecimalToOctal(value)
        // then
        val expected = "257"
        assertEquals(expected, result)
    }

    @Test
    fun `should return zero when convert hexadecimal number to octal with invalid data`() {
        // given
        val value = "Ag41"
        // when
        val result = Converter.hexadecimalToOctal(value)
        // then
        val expected = "0"
        assertEquals(expected, result)
    }
}