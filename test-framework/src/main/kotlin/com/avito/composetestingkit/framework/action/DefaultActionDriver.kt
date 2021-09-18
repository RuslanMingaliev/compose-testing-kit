package com.avito.composetestingkit.framework.action

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider

class DefaultActionDriver(
    private val provider: SemanticsNodeInteractionsProvider,
    private val matcher: SemanticsMatcher
) : ActionDriver {

    override fun perform(func: SemanticsNodeInteraction.() -> Unit) {
        provider.onNode(matcher).func()
    }
}
