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
import dev.jamesyox.svg4kt.tags.categories.category.FilterPrimitiveElement
import dev.jamesyox.svg4kt.tags.categories.container.DescriptiveElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.ElementContainer
import dev.jamesyox.svg4kt.tags.categories.container.LightSourceElementContainer
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public data object FeSpecularLighting :
    SvgTag,
    FilterPrimitiveElement,
    DescriptiveElementContainer,
    LightSourceElementContainer,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.In,
    AttributeContainer.KernelUnitLength,
    AttributeContainer.LightingColor,
    AttributeContainer.Result,
    AttributeContainer.SpecularConstant,
    AttributeContainer.SpecularExponent,
    AttributeContainer.SurfaceScale,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feSpecularLighting"
}

/**
 * The `<feSpecularLighting>` SVG filter primitive lights a source graphic using the alpha channel as a bump map.
 * The resulting image is an RGBA image based on the light color. The lighting calculation follows the standard specular
 * component of the Phong lighting model. The resulting image depends on the light color, light position and surface
 * geometry of the input bump map. The result of the lighting calculation is added.
 * The filter primitive assumes that the viewer is at infinity in the z direction.
 *
 * This filter primitive produces an image which contains the specular reflection part of the lighting calculation.
 * Such a map is intended to be combined with a texture using the add term of the arithmetic [feComposite] method.
 * Multiple light sources can be simulated by adding several of these light maps before applying it to the
 * texture image.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * You can use [dev.jamesyox.svg4kt.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeSpecularLighting)
public fun <T> feSpecularLighting(content: context(AttributeConsumer, @SvgTagDSL FeSpecularLighting) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeSpecularLighting, content = content)
}
