package com.aj.jpcsample.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aj.jpcsample.R
import com.aj.jpcsample.jpc.ui.theme.JpcTutorialTheme

class JpcTutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JpcTutorialTheme {
                JpcTutorial(
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
fun JpcTutorial(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()) // adding scroll since content is long
    ) {
        TutorialHeader()
        TutorialText(
            stringResource(R.string.jetpack_compose_tutorial_title),
            stringResource(R.string.brief),
            stringResource(R.string.desc),
        )
    }
}

@Composable // Header Image for Tutorial screen
fun TutorialHeader() {
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        alignment = Alignment.TopCenter
    )
}

@Composable // Jpc tutorial text
fun TutorialText(title: String, brief: String, description: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            // fontSize = 24.sp,
            style = MaterialTheme.typography.headlineMedium, // Better to use Material theme default size
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Text(
            text = brief,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
    }
}

@Preview
@Composable
fun JocTutorialPreview() {
    JpcTutorialTheme(
        {
            JpcTutorial(
                modifier = Modifier
            )
        }
    )
}