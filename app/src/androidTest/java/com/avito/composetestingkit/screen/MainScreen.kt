package com.avito.composetestingkit.screen

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasTestTag
import com.avito.composetestingkit.common.C
import com.avito.composetestingkit.framework.pageobject.Screen
import com.avito.composetestingkit.framework.pageobject.ViewElement
import com.avito.composetestingkit.framework.text.TextElement

class MainScreen(
    provider: SemanticsNodeInteractionsProvider
) : Screen<MainScreen>(provider, hasTestTag(C.tag.root)) {

    private val display: ViewElement = child { hasTestTag(C.tag.display) }
    private val controlPanel: ViewElement = child { hasTestTag(C.tag.control_panel) }

    val value: TextElement = display.child { hasTestTag(C.tag.value) }
    val increaseBtn: ViewElement = controlPanel.child { hasTestTag(C.tag.increase) }
    val decreaseBtn: ViewElement = controlPanel.child { hasTestTag(C.tag.decrease) }
}
