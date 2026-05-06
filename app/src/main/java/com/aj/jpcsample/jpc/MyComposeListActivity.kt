package com.aj.jpcsample.jpc

import android.R.attr.name
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aj.jpcsample.jpc.ui.theme.MyComposeListTheme

class MyComposeListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeListTheme {
                MyComposeList()
            }
        }
    }
}

@Composable
fun MyComposeList() {
    val context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                value = name,
                onValueChange = { text ->
                    name = text
                },
            )

            Button(
                modifier = Modifier
                    .padding(8.dp),
                onClick = {
                    Toast.makeText(context, "blabla", Toast.LENGTH_SHORT).show()
                    if (name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            items(names) { currentName ->
                Text(
                    text = currentName,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clickable {
                            Toast.makeText(
                                context,
                                "You clicked on $currentName",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                )
                HorizontalDivider()
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyComposeListPreview() {
    MyComposeList()
}