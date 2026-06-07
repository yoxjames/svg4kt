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
import dev.jamesyox.svg4kt.tags.categories.category.BasicShapeElement
import dev.jamesyox.svg4kt.tags.categories.category.GraphicsElement
import dev.jamesyox.svg4kt.tags.categories.category.ShapeElement
import dev.jamesyox.svg4kt.tags.categories.container.AnimationElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object Polyline :
    SvgTag,
    BasicShapeElement,
    GraphicsElement,
    ShapeElement,
    AnimationElementContainer,
    DescriptiveElementContainer,
    AttributeContainer.ClipPath,
    AttributeContainer.Fill.Presentational,
    AttributeContainer.FillOpacity,
    AttributeContainer.FillRule,
    AttributeContainer.MarkerEnd,
    AttributeContainer.MarkerMid,
    AttributeContainer.MarkerStart,
    AttributeContainer.Mask,
    AttributeContainer.Opacity,
    AttributeContainer.PaintOrder,
    AttributeContainer.PathLength,
    AttributeContainer.PointerEvents,
    AttributeContainer.Points,
    AttributeContainer.RequiredExtensions,
    AttributeContainer.ShapeRendering,
    AttributeContainer.Stroke,
    AttributeContainer.StrokeDasharray,
    AttributeContainer.StrokeDashoffset,
    AttributeContainer.StrokeLinecap,
    AttributeContainer.StrokeLinejoin,
    AttributeContainer.StrokeMiterlimit,
    AttributeContainer.StrokeOpacity,
    AttributeContainer.StrokeWidth,
    AttributeContainer.SystemLanguage,
    AttributeContainer.Transform,
    AttributeContainer.VectorEffect,
    AttributeContainer.Visibility {
    override val tagName: String = "polyline"
}

/**
 * The <polyline> SVG element is an SVG basic shape that creates straight lines connecting several points.
 * Typically, a polyline is used to create open shapes as the last point doesn't have to be connected to the first
 * point. For closed shapes see the [polygon] element.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.Polyline)
public fun <T> polyline(content: context(AttributeConsumer, @SvgTagDSL Polyline) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = Polyline, content = content)
}
