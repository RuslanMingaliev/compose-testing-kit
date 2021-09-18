package com.avito.composetestingkit.framework.assertion

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.assert

class DefaultAssertionDriver(
    private val provider: SemanticsNodeInteractionsProvider,
    private val matcher: SemanticsMatcher
) : AssertionDriver {

    override fun check(vararg matchers: SemanticsMatcher) {
        val node = provider.onNode(matcher)
        matchers.forEach { matcher ->
            node.assert(matcher)
        }
    }

    override fun check(func: () -> SemanticsMatcher) {
        val node = provider.onNode(matcher)
        node.assert(matcher)
    }
}
