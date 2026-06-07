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

public data object FeDisplacementMap :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.Animate,
    ElementContainer.Set,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.Result,
    AttributeContainer.Scale,
    AttributeContainer.Width,
    AttributeContainer.X,
    AttributeContainer.XChannelSelector,
    AttributeContainer.YChannelSelector {
    override val tagName: String = "feDisplacementMap"
}

/**
 * The `<feDisplacementMap>` SVG filter primitive uses the pixel values from the image from in2 to spatially displace
 * the image from in.
 *
 * The formula for the transformation looks like this:
 *
 * `P'(x,y) ← P(x + scale * (XC(x,y) - 0.5), y + scale * (YC(x,y) - 0.5))`
 *
 * where `P(x,y)` is the input image, in, and `P'(x,y)` is the destination. `XC(x,y)` and `YC(x,y)` are the component
 * values of the channel designated by [dev.jamesyox.svg4kt.attr.attrs.xChannelSelector]
 * and [dev.jamesyox.svg4kt.attr.attrs.yChannelSelector].
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4kt.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeDisplacementMap)
public fun <T> feDisplacementMap(content: context(AttributeConsumer, @SvgTagDSL FeDisplacementMap) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeDisplacementMap, content = content)
}
