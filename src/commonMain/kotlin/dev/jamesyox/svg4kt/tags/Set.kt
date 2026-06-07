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
import dev.jamesyox.svg4kt.tags.categories.category.AnimationElement
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Set :
    SvgTag,
    AnimationElement,
    DescriptiveElementContainer,
    AttributeContainer.AttributeName,
    AttributeContainer.AttributeType,
    AttributeContainer.Begin,
    AttributeContainer.Dur,
    AttributeContainer.End,
    AttributeContainer.Fill.Animation,
    AttributeContainer.Href,
    AttributeContainer.KeyPoints,
    AttributeContainer.Max,
    AttributeContainer.Min,
    AttributeContainer.RepeatCount,
    AttributeContainer.RepeatDur,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.Restart,
    AttributeContainer.SystemLanguage,
    AttributeContainer.To {
    override val tagName: String = "set"
}

/**
 * The `<set>` SVG element provides a method of setting the value of an attribute for a specified duration.
 *
 * It supports all attribute types, including those that cannot reasonably be interpolated, such as string and boolean
 * values. For attributes that can be reasonably be interpolated, the [animate] is usually preferred.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Set)
public fun <T> set(content: context (AttributeConsumer, @SvgTagDSL Set) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Set, content = content)
}
