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

package dev.jamesyox.svg4k.tags

import dev.jamesyox.svg4k.SvgTag
import dev.jamesyox.svg4k.SvgTagDSL
import dev.jamesyox.svg4k.TagConsumer
import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.attr.AttributeContainer
import dev.jamesyox.svg4k.consumeTag
import dev.jamesyox.svg4k.tags.categories.category.FilterPrimitiveElement
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object FeComponentTransfer :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.FeFuncA,
    ElementContainer.FeFuncR,
    ElementContainer.FeFuncB,
    ElementContainer.FeFuncG,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.Result,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feComponentTransfer"
}

/**
 * The `<feComponentTransfer>` SVG filter primitive performs color-component-wise remapping of data for each pixel.
 * It allows operations like brightness adjustment, contrast adjustment, color balance or thresholding.
 *
 * The calculations are performed on non-premultiplied color values. The colors are modified by changing each channel
 * (R, G, B, and A) to the result of what the children [feFuncR], [feFuncB], [feFuncG], and [feFuncA] return.
 * If more than one of the same element is provided, the last one specified is used, and if no element is supplied to
 * modify one of the channels, the effect is the same is if an identity transformation had been given for that channel.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4k.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeComponentTransfer)
public fun <T> feComponentTransfer(content: context(AttributeConsumer, @SvgTagDSL FeComponentTransfer) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeComponentTransfer, content = content)
}
