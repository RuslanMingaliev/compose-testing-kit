package com.avito.composetestingkit.test

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.hasTextExactly
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import com.avito.composetestingkit.MainActivity
import com.avito.composetestingkit.extensions.screens
import org.junit.Rule
import org.junit.Test

class MainScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test() = rule.screens.main {

        // DSL-like
        value {
            hasText("0")
        }

        increaseBtn {
            perform {
                repeat(5) { performClick() }
            }
        }

        // Plain
        value.check(hasTextExactly("5"))
        decreaseBtn.perform { repeat(10) { performClick() } }
        value.check { hasTextExactly("-5") }
    }
}