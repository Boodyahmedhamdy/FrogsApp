package com.example.frogsapp.ui.states

data class AllFrogsScreenUiState(
    val frogs: List<FrogUiState> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)