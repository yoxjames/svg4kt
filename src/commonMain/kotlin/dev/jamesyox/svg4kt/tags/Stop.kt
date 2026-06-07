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
import dev.jamesyox.svg4kt.tags.categories.category.GradientElement
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Stop :
    SvgTag,
    GradientElement,
    ElementContainer.Animate,
    ElementContainer.Script,
    ElementContainer.Set,
    ElementContainer.Style,
    AttributeContainer.StopColor,
    AttributeContainer.StopOpacity,
    AttributeContainer.Offset {
    override val tagName: String = "stop"
}

/**
 * The `<stop>` SVG element defines a color and its position to use on a gradient. This element is always a child of a
 * [linearGradient] or [radialGradient] element.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Stop)
public fun <T> stop(content: context (AttributeConsumer, @SvgTagDSL Stop) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Stop, content = content)
}
