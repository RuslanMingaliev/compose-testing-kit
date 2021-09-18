package com.avito.composetestingkit.framework.text

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.avito.composetestingkit.framework.pageobject.PageObject

class TextElement(
    provider: SemanticsNodeInteractionsProvider,
    matcher: SemanticsMatcher
) : PageObject<TextElement>(provider, matcher), TextAssertions
