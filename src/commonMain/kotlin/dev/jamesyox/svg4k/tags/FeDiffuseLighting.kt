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

package dev.jamesyox.svg4k.tags

import dev.jamesyox.svg4k.SvgTag
import dev.jamesyox.svg4k.SvgTagDSL
import dev.jamesyox.svg4k.TagConsumer
import dev.jamesyox.svg4k.attr.AttributeConsumer
import dev.jamesyox.svg4k.attr.AttributeContainer
import dev.jamesyox.svg4k.consumeTag
import dev.jamesyox.svg4k.tags.categories.category.FilterPrimitiveElement
import dev.jamesyox.svg4k.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4k.tags.categories.container.ElementContainer
import dev.jamesyox.svg4k.tags.categories.container.LightSourceElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// TODO: REQUIRES EXACTLY ONE LIGHT SOURCE ELEMENT. Should we enforce this?
public data object FeDiffuseLighting :
    SvgTag,
    FilterPrimitiveElement,
    DescriptiveElementContainer,
    LightSourceElementContainer,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.DiffuseConstant,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.KernelUnitLength,
    AttributeContainer.LightingColor,
    AttributeContainer.Result,
    AttributeContainer.SurfaceScale,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feDiffuseLighting"
}

/**
 * The `<feDiffuseLighting>` SVG filter primitive lights an image using the alpha channel as a bump map.
 * The resulting image, which is an RGBA opaque image, depends on the light color, light position and surface geometry
 * of the input bump map.
 *
 * The light map produced by this filter primitive can be combined with a texture image using the multiply term of the
 * arithmetic operator of the [feComposite] filter primitive. Multiple light sources can be simulated by adding several
 * of these light maps together before applying it to the texture image.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4k.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeColorMatrix)
public fun <T> feDiffuseLighting(content: context(AttributeConsumer, @SvgTagDSL FeDiffuseLighting) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeDiffuseLighting, content = content)
}
