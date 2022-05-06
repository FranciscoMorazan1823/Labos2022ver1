package com.example.dummydictionary.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummydictionary.data.model.Word
import com.example.dummydictionary.repository.DictionaryRepository
import kotlinx.coroutines.launch

class WordViewModel(private  val repository: DictionaryRepository): ViewModel() {

    val words = repository.getAllWords()

    val  respuesta: Word

    fun addWord(word: Word) {
        viewModelScope.launch {
            repository.addWord(word)
        }
    }

}