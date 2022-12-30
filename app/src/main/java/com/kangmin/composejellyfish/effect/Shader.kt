package com.kangmin.composejellyfish.effect

import org.intellij.lang.annotations.Language

/* Copyright 2022 Google LLC.
   SPDX-License-Identifier: Apache-2.0 */
@Language("AGSL")
val WOBBLE_SHADER = """
    uniform float2 resolution;
    uniform float time;
    uniform shader contents; 
    vec4 main(in vec2 fragCoord) {
    	vec2 uv = fragCoord.xy / resolution.xy * 0.8 + 0.1;
        
        uv += sin(time * vec2(1.0, 2.0) + uv* 2.0) * 0.01;
       
        return contents.eval(uv * resolution.xy);
    }
""".trimIndent()