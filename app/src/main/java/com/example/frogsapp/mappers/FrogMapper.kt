package com.example.frogsapp.mappers

import com.example.frogsapp.data.FrogDTO
import com.example.frogsapp.ui.states.FrogUiState

fun FrogDTO.toUiState(): FrogUiState {
    return FrogUiState(
        name = name,
        imageUrl = imageSrc,
        description = description
    )
}

