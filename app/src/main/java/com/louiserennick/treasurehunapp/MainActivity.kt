package com.louiserennick.treasurehunapp
import androidx.compose.foundation.background

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.louiserennick.treasurehunapp.ui.theme.TreasureHunAppTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TreasureHuntApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreasureHuntApp() {
    val viewModel: TreasureHuntViewModel = viewModel()
    val currentStep by viewModel.currecntStep.collectAsState()
    val totalSteps = viewModel.locations.size

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Offline Treasure Hunt") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFF3E0))
                    .padding(padding)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Clue ${currentStep + 1} of $totalSteps", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))

                Text("Go to: ${viewModel.locations[currentStep]}", style = MaterialTheme.typography.bodyLarge)

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.treasure_map),
                    contentDescription = "City Map",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    viewModel.nextLocation()
                }, enabled = currentStep < totalSteps - 1) {
                    Text("I found it!")
                }

                if (currentStep == totalSteps - 1) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("🎉 You've completed the treasure hunt! Enter the draw now!", color = Color.Green)
                }
            }
        }
    )
}