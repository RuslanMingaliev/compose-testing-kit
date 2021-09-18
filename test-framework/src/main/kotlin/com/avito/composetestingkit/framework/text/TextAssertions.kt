package com.avito.composetestingkit.framework.text

import androidx.compose.ui.test.hasText
import com.avito.composetestingkit.framework.assertion.AssertionDriver

interface TextAssertions : AssertionDriver {
    fun containsText(string: String) {
        check { hasText(string) } // actually containsText
    }
}
