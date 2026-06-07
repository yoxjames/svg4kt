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

package dev.jamesyox.svg4kt.tags.meta

import dev.jamesyox.svg4kt.SvgTag
import dev.jamesyox.svg4kt.SvgTagDSL
import dev.jamesyox.svg4kt.TagConsumer
import dev.jamesyox.svg4kt.attr.AllAttributeContainer
import dev.jamesyox.svg4kt.attr.AttributeConsumer
import dev.jamesyox.svg4kt.consumeTag
import dev.jamesyox.svg4kt.meta.Unsafe
import dev.jamesyox.svg4kt.tags.categories.container.AllElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public class CustomElement(
    override val tagName: String,
) : SvgTag,
    AllElementContainer,
    AllAttributeContainer

context(_: TagConsumer<T>, _: Unsafe)
public fun <T> customElement(
    tagName: String,
    content: context(AttributeConsumer, @SvgTagDSL CustomElement) () -> Unit,
): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = CustomElement(tagName), content = content)
}
