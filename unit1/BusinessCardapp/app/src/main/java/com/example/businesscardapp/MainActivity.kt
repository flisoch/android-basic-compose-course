package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Spacer(modifier = Modifier.height(150.dp))
        }
        Row {
            PersonPreview(
                fullName = stringResource(R.string.contact_name),
                bio = stringResource(R.string.contact_bio)
            )
        }
        Row {
            Spacer(modifier = Modifier.height(150.dp))
        }
        Row {
            ContactInfo()
        }
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
    Divider(color = Color.Gray, thickness = 2.dp)
    Row(
        Modifier
            .fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.width(50.dp))
        Icon(
            icon, null,
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.width(40.dp))
        Text(text = text, color = Color.White)
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun ContactInfo() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        ContactInfoRow(icon = Icons.Filled.Phone, stringResource(R.string.contact_number))
        ContactInfoRow(icon = Icons.Filled.Share, stringResource(R.string.contact_share))
        ContactInfoRow(icon = Icons.Filled.Email, stringResource(R.string.contact_email))
    }
}

@Composable
fun PersonPreview(fullName: String, bio: String) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.description_android_logo),
            modifier = Modifier
                .size(128.dp),
        )
        Text(
            text = fullName,
            fontSize = 48.sp,
            color = Color.White,
        )
        Text(
            text = bio,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFF3ddc84),

            )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            BusinessCard()
        }
    }
}