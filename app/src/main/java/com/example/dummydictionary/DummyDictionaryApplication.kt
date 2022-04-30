package com.example.dummydictionary

import android.app.Application
import com.example.dummydictionary.data.DummyDictionaryDatabase
import com.example.dummydictionary.repository.DictionaryRepository
import com.example.dummydictionary.ui.WordViewModelFactory

class DummyDictionaryApplication: Application() {
    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }

    fun getDictionaryRepository() = with(dataBase) {
        DictionaryRepository(wordDao(), synonymDao(), antonymDao())
    }


}