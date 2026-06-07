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
import dev.jamesyox.svg4kt.attr.AllAttributeContainer
import dev.jamesyox.svg4kt.attr.AttributeConsumer
import dev.jamesyox.svg4kt.consumeTag
import dev.jamesyox.svg4kt.tags.categories.category.GraphicsElement
import dev.jamesyox.svg4kt.tags.categories.category.GraphicsReferencingElement
import dev.jamesyox.svg4kt.tags.categories.category.StructuralElement
import dev.jamesyox.svg4kt.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Use :
    SvgTag,
    GraphicsElement,
    GraphicsReferencingElement,
    StructuralElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AllAttributeContainer {
    override val tagName: String = "use"
}

/**
 * The <use> element takes nodes from within an SVG document, and duplicates them somewhere else.
 * The effect is the same as if the nodes were deeply cloned into a non-exposed DOM,
 * then pasted where the <use> element is, much like cloned `<template>` elements.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Use)
public fun <T> use(content: context(AttributeConsumer, @SvgTagDSL Use) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Use, content = content)
}
