package com.example.frogsapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.frogsapp.R
import com.example.frogsapp.ui.states.FrogUiState

@SuppressLint("ResourceType")
@Composable
fun FrogCard(
    state: FrogUiState,
    modifier: Modifier = Modifier,

) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxSize()
        ) {
            // frog name
            Text(
                text = state.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            // frog image
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(state.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = state.imageDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            // description
            Text(text = state.description, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
fun FrogCardPreview() {
    FrogCard(state = FrogUiState(
        name = "MY best Frog",
        description = "sldkfjlsdkfj" +
                "sdsldkflsdfjlsdfjlsdfjlsdfjsldjls"
    ))
}