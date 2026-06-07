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
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object View :
    SvgTag,
    DescriptiveElementContainer,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.ViewBox,
    AttributeContainer.ZoomAndPan {
    override val tagName: String = "view"
}

/**
 * The `<view>` SVG element defines a particular view of an SVG document. A specific view can be displayed by
 * referencing the `<view>` element's [dev.jamesyox.svg4kt.attr.attrs.id] as the target fragment of a URL.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.View)
public fun <T> view(content: context(AttributeConsumer, @SvgTagDSL View) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = View, content = content)
}
