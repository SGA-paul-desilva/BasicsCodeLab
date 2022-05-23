package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    var mNames = listOf("Sofia","Hamilton","Steven","Brooks","Maddie","Turner",
            "Audrey","Craig",
            "Camila","Robinson",
            "Brooke","Rogers",
            "Garry","Dixon",
            "Dainton","Reed",
            "Albert","Martin",
            "Harold","Richardson",
            "Sofia","Murphy",
            "Sabrina","Carroll",
            "Vincent","Barnes",
            "James","Riley",
            "Abigail","Parker",
            "Justin","Turner",
            "Hailey","Tucker",
            "Eddy","Barrett",
            "Mary","Hamilton",
            "Cadie","Riley",
            "Amanda","Walker",
            "Lenny","Thomas",
            "Cherry","Hawkins",
            "Annabella","Murphy",
            "Alisa","Phillips",
            "James","Edwards",
            "Rubie","Hamilton",
            "Nicholas","Hamilton",
            "Arianna","Cooper",
            "Martin","Edwards")
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                OnboardingMyApp()
            }
        }
    }


    @Composable
    fun OnboardingMyApp() {
        var shouldShowOnboarding by remember { mutableStateOf(true) }
        if (shouldShowOnboarding) {
            OnboardingScreen(OnContinueClicked = { shouldShowOnboarding = false })
        } else {
            mNames.sortedBy { it.length }
            Greetings(mNames)
        }
    }

    @Composable
    fun Greetings(names: List<String>) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                items(names) {
                    name ->
                    Greeting(name = name)
                }
            }

        }
    }


    @Composable
    fun Greeting(name: String) {
        var expanded by remember { mutableStateOf(false) }
        var extraPadding = if (expanded) 48.dp else 0.dp
        Surface(
            color = MaterialTheme.colors.primary, modifier = Modifier.padding(
                horizontal = 8.dp,
                vertical = 4.dp
            )
        ) {
            Row(Modifier.padding(24.dp)) {
                Column(
                    Modifier
                        .padding(bottom = extraPadding)
                        .fillMaxWidth()
                        .weight(1F)
                ) {
                    Text(text = "Hello, ")
                    Text(text = "$name!")
                }
                OutlinedButton(onClick = { expanded = !expanded }) {
                    Text(if (expanded) "Show less" else "Show more")
                }
            }
        }
    }

    @Composable
    fun OnboardingScreen(OnContinueClicked: () -> Unit) {
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

}