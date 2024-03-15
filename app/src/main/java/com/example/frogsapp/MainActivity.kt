package com.example.frogsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.frogsapp.ui.screens.AllFrogsScreen
import com.example.frogsapp.ui.states.AllFrogsScreenUiState
import com.example.frogsapp.ui.theme.FrogsAppTheme
import com.example.frogsapp.ui.viewmodels.AllFrogsScreenViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrogsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel: AllFrogsScreenViewModel = viewModel()
                    val state = viewmodel.state.collectAsState()

                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Frogs") },
                                actions = {
                                    IconButton(
                                        onClick = { viewmodel.refresh() }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Refresh,
                                            contentDescription = "refresh frogs"
                                        )
                                    }
                                }
                            )
                        },

                    ) {
                        AllFrogsScreen(
                            state = state.value,
                            modifier = Modifier.padding(it)
                        )
                    }

                }
            }
        }
    }
}

