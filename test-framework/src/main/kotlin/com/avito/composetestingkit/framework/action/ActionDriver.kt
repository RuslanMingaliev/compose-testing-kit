package com.avito.composetestingkit.framework.action

import androidx.compose.ui.test.SemanticsNodeInteraction

interface ActionDriver {
    fun perform(func: SemanticsNodeInteraction.() -> Unit)
}
