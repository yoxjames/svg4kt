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

public data object FeMerge :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.FeMergeNode,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.Result,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feMerge"
}

/**
 * The `<feMerge>` SVG element allows filter effects to be applied concurrently instead of sequentially.
 * This is achieved by other filters storing their output via the result attribute and then accessing it in a
 * `[feMergeNode] child.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4k.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeMerge)
public fun <T> feMerge(content: context(AttributeConsumer, @SvgTagDSL FeMerge) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeMerge, content = content)
}
