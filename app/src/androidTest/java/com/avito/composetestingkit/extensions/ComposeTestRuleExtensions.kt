package com.avito.composetestingkit.extensions

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import com.avito.composetestingkit.screen.MainScreen
import org.junit.rules.TestRule

class Screens(provider: SemanticsNodeInteractionsProvider) {
    val main = MainScreen(provider)
}

val <R : TestRule, A : ComponentActivity> AndroidComposeTestRule<R, A>.screens: Screens
    get() = Screens(this)
