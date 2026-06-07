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
import dev.jamesyox.svg4kt.tags.categories.category.GraphicsElement
import dev.jamesyox.svg4kt.tags.categories.category.GraphicsReferencingElement
import dev.jamesyox.svg4kt.tags.categories.category.RenderableElement
import dev.jamesyox.svg4kt.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Image :
    SvgTag,
    GraphicsElement,
    GraphicsReferencingElement,
    RenderableElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    ElementContainer.Animate,
    ElementContainer.AnimateMotion,
    ElementContainer.AnimateTransform,
    ElementContainer.Script,
    ElementContainer.Set,
    ElementContainer.Style,
    AttributeContainer.ClipPath,
    AttributeContainer.Crossorigin,
    AttributeContainer.Decoding,
    AttributeContainer.Fetchpriority,
    AttributeContainer.Height,
    AttributeContainer.ImageRendering,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PointerEvents,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility,
    AttributeContainer.Width {
    override val tagName: String = "image"
}

/**
 * The `<image>` SVG element includes images inside SVG documents. It can display raster image files or other SVG files.
 *
 * The only image formats SVG software must support are JPEG, PNG, and other SVG files. Animated GIF behavior is
 * undefined.
 *
 * SVG files displayed with `<image>` are treated as an image: external resources aren't loaded, `:visited` styles
 * aren't applied, and they cannot be interactive. To include dynamic SVG elements, try [use] with an external URL.
 * To include SVG files and run scripts inside them, try `<object> inside of [foreignObject].
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Image)
public fun <T> image(content: context(AttributeConsumer, @SvgTagDSL Image) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Image, content = content)
}
