package com.avito.composetestingkit.framework.pageobject

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider

class ViewElement(
    provider: SemanticsNodeInteractionsProvider,
    matcher: SemanticsMatcher
) : PageObject<ViewElement>(provider, matcher)
