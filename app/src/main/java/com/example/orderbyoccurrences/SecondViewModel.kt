package com.example.orderbyoccurrences

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SecondViewModel : ViewModel() {

    private var _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun sortByOccurrences(text: String) {
        viewModelScope.launch {
            val words = text.trim().split(" ")
            val wordOccurrences = mutableMapOf<String, Int>()

            for (word in words) {
                val count = wordOccurrences[word] ?: 0
                wordOccurrences[word] = count + 1
            }
            val sortedOccurrences = wordOccurrences.toList().sortedByDescending { (_, value) -> value }

            _uiState.update { UiState.Success(sortedOccurrences) }
        }
    }


}

sealed interface UiState {
    data object Loading : UiState
    data class Success(val sortedOccurrences: List<Pair<String, Int>>) : UiState
}