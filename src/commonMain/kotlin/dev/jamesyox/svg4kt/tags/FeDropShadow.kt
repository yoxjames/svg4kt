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

import dev.jamesyox.svg4kt.SvgTag
import dev.jamesyox.svg4kt.SvgTagDSL
import dev.jamesyox.svg4kt.TagConsumer
import dev.jamesyox.svg4kt.attr.AttributeConsumer
import dev.jamesyox.svg4kt.attr.AttributeContainer
import dev.jamesyox.svg4kt.consumeTag
import dev.jamesyox.svg4kt.tags.categories.category.FilterPrimitiveElement
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object FeDropShadow :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.Animate,
    ElementContainer.Script,
    ElementContainer.Set,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.FloodColor,
    AttributeContainer.FloodOpacity,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.Result,
    AttributeContainer.StdDeviation,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feDropShadow"
}

/**
 * The `<feDropShadow>` SVG filter primitive creates a drop shadow of the input image. It can only be used inside a
 * [filter] element.
 *
 * Note: The drop shadow color and opacity can be changed by using the [dev.jamesyox.svg4kt.attr.attrs.floodColor] and
 * [dev.jamesyox.svg4kt.attr.attrs.floodOpacity] presentation attributes.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4kt.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeDropShadow)
public fun <T> feDropShadow(content: context(AttributeConsumer, @SvgTagDSL FeDropShadow) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeDropShadow, content = content)
}
