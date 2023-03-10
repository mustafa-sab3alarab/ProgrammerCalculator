package com.example.programmercalculator

import org.junit.Assert.assertEquals
import org.junit.Test

internal class ConvertTest {

    @Test
    fun binaryToDecimal() {
        // given
        val value = 1011
        // when
        val result = Convert.binaryToDecimal(value)
        // then
        val expected = "11"
        assertEquals(expected, result)
    }

    @Test
    fun binaryToOctal() {
        // given
        val value = 1011
        // when
        val result = Convert.binaryToOctal(value)
        // then
        val expected = "13"
        assertEquals(expected, result)
    }

    @Test
    fun binaryToHexadecimal() {
        // given
        val value = 1011
        // when
        val result = Convert.binaryToHexadecimal(value)
        // then
        val expected = "B"
        assertEquals(expected, result)
    }

    @Test
    fun decimalToBinary() {
        // given
        val value = 12
        // when
        val result = Convert.decimalToBinary(value)
        // then
        val expected = "1100"
        assertEquals(expected, result)
    }

    @Test
    fun decimalToOctal() {
        // given
        val value = 12
        // when
        val result = Convert.decimalToOctal(value)
        // then
        val expected = "14"
        assertEquals(expected, result)
    }

    @Test
    fun decimalToHexadecimal() {
        // given
        val value = 12
        // when
        val result = Convert.decimalToHexadecimal(value)
        // then
        val expected = "C"
        assertEquals(expected, result)
    }

    @Test
    fun octalToBinary() {
        // given
        val value = 12
        // when
        val result = Convert.octalToBinary(value)
        // then
        val expected = "1010"
        assertEquals(expected, result)
    }

    @Test
    fun octalToDecimal() {
        // given
        val value = 12
        // when
        val result = Convert.octalToDecimal(value)
        // then
        val expected = "10"
        assertEquals(expected, result)
    }

    @Test
    fun octalToHexadecimal() {
        // given
        val value = 12
        // when
        val result = Convert.octalToHexadecimal(value)
        // then
        val expected = "A"
        assertEquals(expected, result)
    }

    @Test
    fun hexadecimalToBinary() {
        // given
        val value = "AF"
        // when
        val result = Convert.hexadecimalToBinary(value)
        // then
        val expected = "10101111"
        assertEquals(expected, result)
    }

    @Test
    fun hexadecimalToDecimal() {
        // given
        val value = "AF"
        // when
        val result = Convert.hexadecimalToDecimal(value)
        // then
        val expected = "175"
        assertEquals(expected, result)
    }

    @Test
    fun hexadecimalToOctal() {
        // given
        val value = "AF"
        // when
        val result = Convert.hexadecimalToOctal(value)
        // then
        val expected = "257"
        assertEquals(expected, result)
    }
}