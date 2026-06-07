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

public data object FeTurbulence :
    SvgTag,
    LightSourceElement,
    ElementContainer.Animate,
    ElementContainer.Set,
    AttributeContainer.BaseFrequency,
    AttributeContainer.ColorInterpolationFilters,
    AttributeContainer.Height,
    AttributeContainer.NumOctaves,
    AttributeContainer.Result,
    AttributeContainer.Seed,
    AttributeContainer.StitchTiles,
    AttributeContainer.Width,
    AttributeContainer.X {
    override val tagName: String = "feTurbulence"
}

/**
 * The `<feTurbulence>` SVG filter primitive creates an image using the Perlin turbulence function. It allows the
 * synthesis of artificial textures like clouds or marble. The resulting image will fill the entire filter primitive
 * subregion.
 *
 * Like other filter primitives, it handles color components in the linearRGB color space by default.
 * ou can use [dev.jamesyox.svg4kt.attr.attrs.colorInterpolationFilters] to use sRGB instead.
 */
@IgnorableReturnValue
context(_: TagConsumer<T>, _: ElementContainer.FeTurbulence)
public fun <T> feTurbulence(content: context(AttributeConsumer, @SvgTagDSL FeTurbulence) () -> Unit): T {
    contract {
        callsInPlace(content, InvocationKind.EXACTLY_ONCE)
    }
    return consumeTag(tag = FeTurbulence, content = content)
}
