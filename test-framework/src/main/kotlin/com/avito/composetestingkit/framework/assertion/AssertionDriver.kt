package com.avito.composetestingkit.framework.assertion

import androidx.compose.ui.test.SemanticsMatcher

interface AssertionDriver {
    fun check(vararg matchers: SemanticsMatcher)
    fun check(func: () -> SemanticsMatcher)
}
