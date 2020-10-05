package com.sample

import kotlin.reflect.KClass
import java.math.BigDecimal
import java.math.RoundingMode

fun<T: Any> T.getClass(): KClass<T> {
    return javaClass.kotlin
}

infix fun BigDecimal.withScale(scale: Int): BigDecimal {
    return this.setScale(scale, RoundingMode.HALF_UP)
}