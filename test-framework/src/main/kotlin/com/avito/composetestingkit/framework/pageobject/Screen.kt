package com.avito.composetestingkit.framework.pageobject

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider

abstract class Screen<out T : Screen<T>>(
    provider: SemanticsNodeInteractionsProvider,
    matcher: SemanticsMatcher
) : PageObject<T>(provider, matcher)
