package com.example.frogsapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frogsapp.ui.components.FrogCard
import com.example.frogsapp.ui.states.AllFrogsScreenUiState

@Composable
fun AllFrogsScreen(
    state: AllFrogsScreenUiState,
    modifier: Modifier = Modifier
) {
    if(state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Fetching Frogs .....")
        }
    }
    LazyColumn(modifier = modifier) {
        items(state.frogs) {
            FrogCard(state = it, modifier = Modifier.padding(8.dp))
        }
    }
}