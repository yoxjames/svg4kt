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

package dev.jamesyox.svg4kt.tags

import dev.jamesyox.svg4kt.attr.attrs.ViewBox
import dev.jamesyox.svg4kt.attr.attrs.d
import dev.jamesyox.svg4kt.attr.attrs.fill
import dev.jamesyox.svg4kt.attr.attrs.href
import dev.jamesyox.svg4kt.attr.attrs.id
import dev.jamesyox.svg4kt.attr.attrs.stroke
import dev.jamesyox.svg4kt.attr.attrs.viewBox
import dev.jamesyox.svg4kt.attr.types.obj.SvgColor
import dev.jamesyox.svg4kt.attr.types.obj.SvgId
import dev.jamesyox.svg4kt.attr.types.obj.SvgPaint
import dev.jamesyox.svg4kt.consumers.svgString
import dev.jamesyox.svg4kt.tags.categories.container.unaryPlus
import dev.jamesyox.svg4kt.util.M
import dev.jamesyox.svg4kt.util.Q
import kotlin.test.Test
import kotlin.test.assertEquals

class TextPathTest {
    @Test
    fun mozillaExample() {
        val expected =
            """
            <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 100 100">
                <path
                    id="myPath"
                    fill="none"
                    stroke="red"
                    d="M 10 90 Q 90 90 90 45 Q 90 10 50 10 Q 10 10 10 40 Q 10 70 45 70 Q 70 70 75 50" />
                <text>
                    <textPath
                        href="#myPath">
                        Quick brown fox jumps over the lazy dog.
                    </textPath>
                </text>
            </svg>
            """.trimIndent()

        val actual =
            svgString(isPrettyPrint = true) {
                svg {
                    val myPath = SvgId("myPath")
                    viewBox = ViewBox(0, 0, 100, 100)
                    path {
                        id = myPath
                        fill = SvgPaint.None
                        stroke(SvgColor.Red)
                        d {
                            M(10, 90)
                            Q(90, 90, 90, 45)
                            Q(90, 10, 50, 10)
                            Q(10, 10, 10, 40)
                            Q(10, 70, 45, 70)
                            Q(70, 70, 75, 50)
                        }
                    }
                    text {
                        textPath {
                            href = myPath
                            +"Quick brown fox jumps over the lazy dog."
                        }
                    }
                }
            }

        assertEquals(expected, actual)
    }
}
