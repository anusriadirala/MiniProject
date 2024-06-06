package com.example.miniproject1.profilescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        MyScreen(
            firstName = "",
            lastName = "",
            gender = ""
        )
    }
}


@Composable
fun NameInputField(label: String, value: MutableState<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(Color.White)
    ) {
        Text(
            text = label,
            style = TextStyle(color = Color.Black),
            modifier = Modifier
                .padding(start = 16.dp)
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = value.value,
            onValueChange = { value.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.White)
                .height(50.dp)
        )
    }
}
@Composable
fun MyScreen(
    firstName: String = "",
    lastName: String = "",
    gender: String = "",
    onNextClicked: (String, String, String) -> Unit = { _, _, _ -> }
) {
    val genderOptions = listOf("Male", "Female", "Others")
    val selectedGender = remember { mutableStateOf(gender) }
    val firstNameState = remember { mutableStateOf(firstName) }
    val lastNameState = remember { mutableStateOf(lastName) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(color = Color(0xFFF6995C))
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "LET'S GET TO KNOW",
                    overflow = TextOverflow.Visible,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "YOU BETTER!",
                    overflow = TextOverflow.Visible,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(start = 60.dp),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "WHAT'S YOUR NAME?",
                    overflow = TextOverflow.Visible,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            NameInputField("First Name", firstNameState)
            NameInputField("Last Name", lastNameState)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .background(Color.White)
            ) {
                NameInputField("Age", firstNameState)
                NameInputField("Roll Number", firstNameState)

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                Button(
                    onClick = {
                        onNextClicked(
                            firstNameState.value,
                            lastNameState.value,
                            selectedGender.value
                        )
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFF51829B)),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier
                        .width(200.dp)
                        .height(60.dp)
                ) {
                    Text(
                        text = "Next",
                        style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp)
                    )
                }
                Spacer(modifier = Modifier.height(400.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreen()
}




