package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                OnboardingMyApp()
            }
        }
    }
}

@Composable
fun OnboardingMyApp() {
    var shouldShowOnboarding by remember { mutableStateOf(true) }
    if(shouldShowOnboarding) {
        OnboardingScreen(OnContinueClicked = {shouldShowOnboarding = false})
    } else {
        Greetings()
    }
}

@Composable
fun Greetings(names : List<String> = listOf("World","Compose")) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            for(name in names) {
                Greeting("$name")
            }
        }

    }
}



@Composable
fun Greeting(name: String) {
    var expanded by remember { mutableStateOf(false) }
    var extraPadding = if(expanded) 48.dp else 0.dp
    Surface(color = MaterialTheme.colors.primary,modifier = Modifier.padding(horizontal =8.dp,
        vertical = 4.dp)) {
        Row (Modifier.padding(24.dp)) {
            Column(
                Modifier
                    .padding(bottom = extraPadding)
                    .fillMaxWidth()
                    .weight(1F)) {
                Text(text = "Hello, ")
                Text(text = "$name!")
            }
            OutlinedButton(onClick = { expanded = !expanded }) {
                Text(if(expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun OnboardingScreen(OnContinueClicked : () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = OnContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen({})
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        OnboardingMyApp()
    }
}