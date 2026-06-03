/*
 * Copyright 2026 James Yox
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package dev.jamesyox.svg4k.misc

import dev.jamesyox.svg4k.attr.types.obj.SvgColor
import kotlin.test.Test
import kotlin.test.assertEquals

class ColorTest {
    @Test
    fun testLeadingZeros() {
        val actual = SvgColor.Hex.RGB(0x001111).svgString
        val expected = "#001111"
        assertEquals(expected, actual)
    }

    @Test
    fun testOverflowingRGB() {
        val actual = SvgColor.Hex.RGB(0x11223344).svgString
        val expected = "#112233"
        assertEquals(expected, actual)
    }

    @Test
    fun testAlphaChannels() {
        val actual = SvgColor.Hex.RGBA(0x00111111).svgString
        val expected = "#00111111"
        assertEquals(expected, actual)
    }

    @Test
    fun testTooFewDigits() {
        val actual = SvgColor.Hex.RGB(0x11).svgString
        val expected = "#000011"
        assertEquals(expected, actual)
    }

    @Test
    fun testOverflowingRGBA() {
        val actual = SvgColor.Hex.RGBA(0x1122334455).svgString
        val expected = "#11223344"
        assertEquals(expected, actual)
    }

    @Test
    fun testNegativeValue() {
        val actual = SvgColor.Hex.RGB(-10).svgString
        val expected = "#000000"
        assertEquals(expected, actual)
    }

    @Test
    fun testNegativeRGBAValue() {
        val actual = SvgColor.Hex.RGBA(-10).svgString
        val expected = "#00000000"
        assertEquals(expected, actual)
    }

    @Test
    fun test() {
        assertEquals(0x111111, 0x00111111)
    }
}