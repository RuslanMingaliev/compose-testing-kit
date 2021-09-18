@file:Suppress("unused", "UNCHECKED_CAST")

package com.avito.composetestingkit.framework.pageobject

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasParent
import com.avito.composetestingkit.framework.action.ActionDriver
import com.avito.composetestingkit.framework.action.DefaultActionDriver
import com.avito.composetestingkit.framework.assertion.AssertionDriver
import com.avito.composetestingkit.framework.assertion.DefaultAssertionDriver

abstract class PageObject<out T : PageObject<T>>(
    val provider: SemanticsNodeInteractionsProvider,
    val matcher: SemanticsMatcher
) : ActionDriver by DefaultActionDriver(provider, matcher),
    AssertionDriver by DefaultAssertionDriver(provider, matcher) {

    constructor(
        provider: SemanticsNodeInteractionsProvider,
        matcher: () -> SemanticsMatcher
    ) : this(provider, matcher())

    protected inline fun <reified N> PageObject<*>.child(childMatchers: () -> SemanticsMatcher): N {
        return N::class.java.getConstructor(
            SemanticsNodeInteractionsProvider::class.java,
            SemanticsMatcher::class.java
        ).newInstance(provider, hasParent(matcher) and childMatchers())
    }

    operator fun invoke(func: T.() -> Unit) {
        func(this as T)
    }
}
