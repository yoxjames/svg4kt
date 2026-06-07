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
import dev.jamesyox.svg4kt.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ShapeElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object ClipPath :
    SvgTag,
    AnimationElementContainer,
    DescriptiveElementContainer,
    ShapeElementContainer,
    ElementContainer.Text,
    ElementContainer.Use,
    AttributeContainer.ClipPath,
    AttributeContainer.ClipPathUnits,
    AttributeContainer.Mask,
    AttributeContainer.PointerEvents,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform {
    override val tagName: String = "clipPath"
}

/**
 * The `<clipPath>` SVG element defines a clipping path, to be used by the [dev.jamesyox.svg4kt.attr.attrs.clipPath]
 * property.
 *
 * A clipping path restricts the region to which paint can be applied. Conceptually, parts of the drawing that lie
 * outside of the region bounded by the clipping path are not drawn.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.ClipPath)
public fun <T> clipPath(content: context(AttributeConsumer, @SvgTagDSL ClipPath) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = ClipPath, content = content)
}
