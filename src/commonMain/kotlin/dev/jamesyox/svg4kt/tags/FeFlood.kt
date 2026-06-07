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

public data object FeFlood :
    SvgTag,
    FilterPrimitiveElement,
    ElementContainer.Animate,
    ElementContainer.Set,
    AttributeContainer.FloodColor,
    AttributeContainer.FloodOpacity,
    AttributeContainer.Height,
    AttributeContainer.Result,
    AttributeContainer.Width,
    AttributeContainer.X,
    AttributeContainer.Y {
    override val tagName: String = "feFlood"
}

/**
 * The `<feFlood>` SVG filter primitive fills the filter subregion with the color and opacity defined by
 * [dev.jamesyox.svg4kt.attr.attrs.floodColor] and [dev.jamesyox.svg4kt.attr.attrs.floodOpacity].
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeFlood)
public fun <T> feFlood(content: context(AttributeConsumer, @SvgTagDSL FeFlood) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeFlood, content = content)
}
