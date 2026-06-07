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

public data object FeImage :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.Animate,
    ElementContainer.AnimateTransform,
    ElementContainer.Set,
    AttributeContainer.Fetchpriority,
    AttributeContainer.Height,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.Result,
    AttributeContainer.Width,
    AttributeContainer.X,
    AttributeContainer.Y {
    override val tagName: String = "feImage"
}

/**
 * The `<feImage>` SVG filter primitive fetches image data from an external source and provides the pixel data as
 * output (meaning if the external source is an SVG image, it is rasterized.)
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeImage)
public fun <T> feImage(content: context(AttributeConsumer, @SvgTagDSL FeImage) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeImage, content = content)
}
