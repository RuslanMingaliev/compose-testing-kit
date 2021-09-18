@file:Suppress("FunctionName")
package com.avito.composetestingkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.avito.composetestingkit.common.C
import com.avito.composetestingkit.ui.theme.ComposeTestingKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestingKitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.testTag(C.tag.root),
                    color = MaterialTheme.colors.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var value: Int by remember { mutableStateOf(0) }
        Display(value)
        Spacer(modifier = Modifier.height(16.dp))
        ControlPanel { value += it }
    }
}

@Composable
fun Display(value: Int) {
    Column(
        modifier = Modifier.testTag(C.tag.display),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Current value",
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            modifier = Modifier.wrapContentWidth().testTag(C.tag.value),
            text = "$value",
            fontSize = 24.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Composable
fun ControlPanel(increaseBy: (Int) -> Unit) {
    Row(modifier = Modifier.testTag(C.tag.control_panel)) {
        Button(modifier = Modifier.testTag(C.tag.increase), onClick = {
            increaseBy(1)
        }) { Text("Increase") }
        Spacer(modifier = Modifier.width(8.dp))
        Button(modifier = Modifier.testTag(C.tag.decrease), onClick = {
            increaseBy(-1)
        }) { Text("Decrease") }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestingKitTheme {
        Counter()
    }
}
