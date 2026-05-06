package com.aj.jpcsample.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aj.jpcsample.R
import com.aj.jpcsample.jpc.ui.theme.MyJpcTheme
import java.util.Vector

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJpcTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        //Top
        Column(
            modifier = Modifier
                .padding(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null
            )

            Text(
                text = "Ajith Joy",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = "Android Developer",
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 20.dp),
            )
        }

        //Bottom
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(
                icon = Icons.Default.Phone,
                text = "+91 9876543210"
            )
            ContactRow(
                icon = Icons.Default.Share,
                text = "@blabla"
            )
            ContactRow(
                icon = Icons.Default.Email,
                text = "xyz@abc.com"
            )
        }

    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            modifier = Modifier.padding(start = 10.dp),
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun MyBusinessCard() {
    MyJpcTheme {
        BusinessCard()
    }
}

