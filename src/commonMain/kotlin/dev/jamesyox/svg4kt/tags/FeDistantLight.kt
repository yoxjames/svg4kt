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
import dev.jamesyox.svg4kt.tags.categories.category.LightSourceElement
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object FeDistantLight :
    SvgTag,
    LightSourceElement,
    ElementContainer.Animate,
    ElementContainer.Set,
    AttributeContainer.Azimuth,
    AttributeContainer.Elevation {
    override val tagName: String = "feDistantLight"
}

/**
 * The `<feDistantLight>` SVG element defines a distant light source that can be used within a lighting filter
 * primitive: [feDiffuseLighting] or [feSpecularLighting].
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeDistantLight)
public fun <T> feDistantLight(content: context(AttributeConsumer, @SvgTagDSL FeDistantLight) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeDistantLight, content = content)
}
