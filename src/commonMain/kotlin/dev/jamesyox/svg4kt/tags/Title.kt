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
import dev.jamesyox.svg4kt.consumeTag
import dev.jamesyox.svg4kt.tags.categories.category.DescriptiveElement
import dev.jamesyox.svg4kt.tags.categories.container.AnyContentContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Title :
    SvgTag,
    DescriptiveElement,
    AnyContentContainer {
    override val tagName: String = "title"
}

/**
 *The `<title>` SVG element provides an accessible, short-text description of any SVG container element or graphics
 * element.
 *
 * Text in a `<title>` element is not rendered as part of the graphic, but browsers usually display it as a tooltip.
 * If an element can be described by visible text, it is recommended to reference that text with an `aria-labelledby`
 * attribute rather than using the `<title>` element.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Title)
public fun <T> title(content: context(AttributeConsumer, @SvgTagDSL Title) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Title, content = content)
}
