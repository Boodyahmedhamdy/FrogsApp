package com.example.frogsapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.frogsapp.data.RetrofitHelper
import com.example.frogsapp.mappers.toUiState
import com.example.frogsapp.ui.states.AllFrogsScreenUiState
import com.example.frogsapp.ui.states.FrogUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllFrogsScreenViewModel: ViewModel() {
    private val _state = MutableStateFlow(AllFrogsScreenUiState())
    val state = _state.asStateFlow()

    private val apiService = RetrofitHelper.getFrogsApi()

    init {
        getAllFrogs()
    }

    fun getAllFrogs() {
        try {
            updateStateIsLoading(true)
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val frogs = apiService.getAllFrogs().execute().body() ?: emptyList()
                    withContext(Dispatchers.Main) {
                        updateStateFrogs(
                            frogs.map { it.toUiState() }
                        )
                        updateStateIsLoading(false)
                    }
                }
            }
        } catch (ex: Exception) {
            updateStateError(ex.toString())
        }
    }

    fun refresh() {
        updateStateFrogs(emptyList())
        getAllFrogs()
    }

    private fun updateStateFrogs(frogs: List<FrogUiState>) {
        try {
            _state.update {
                it.copy(frogs = frogs)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    private fun updateStateError(error: String) {
        try {
            _state.update {
                it.copy(error = error)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    private fun updateStateIsLoading(isLoading: Boolean) {
        _state.update {
            it.copy(isLoading = isLoading)
        }
    }

}