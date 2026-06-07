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
import dev.jamesyox.svg4kt.tags.categories.category.ContainerElement
import dev.jamesyox.svg4kt.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.GradientElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ShapeElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.StructuralElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Marker :
    SvgTag,
    ContainerElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    ShapeElementContainer,
    StructuralElementContainer,
    GradientElementContainer,
    ElementContainer.A,
    ElementContainer.ClipPath,
    ElementContainer.Filter,
    ElementContainer.ForeignObject,
    ElementContainer.Image,
    ElementContainer.Marker,
    ElementContainer.Mask,
    ElementContainer.Pattern,
    ElementContainer.Script,
    ElementContainer.Style,
    ElementContainer.Switch,
    ElementContainer.Text,
    ElementContainer.View,
    AttributeContainer.ClipPath,
    AttributeContainer.MarkerHeight,
    AttributeContainer.MarkerUnits,
    AttributeContainer.MarkerWidth,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.Orient,
    AttributeContainer.PointerEvents,
    AttributeContainer.PreserveAspectRatio,
    AttributeContainer.ViewBox {
    override val tagName: String = "marker"
}

/**
 * The `<marker>` SVG element defines a graphic used for drawing arrowheads or polymarkers on a given [path], [line],
 * [polyline] or [polygon] element.
 *
 * Markers can be attached to shapes using the [dev.jamesyox.svg4kt.attr.attrs.markerStart],
 * [dev.jamesyox.svg4kt.attr.attrs.markerMid], and [dev.jamesyox.svg4kt.attr.attrs.markerEnd] properties.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Marker)
public fun <T> marker(content: context(AttributeConsumer, @SvgTagDSL Marker) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Marker, content = content)
}
