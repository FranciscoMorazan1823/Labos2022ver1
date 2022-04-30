package com.example.dummydictionary.repository

import androidx.lifecycle.MutableLiveData
import com.example.dummydictionary.data.dao.AntonymDao
import com.example.dummydictionary.data.dao.SynonymDao
import com.example.dummydictionary.data.dao.WordDao
import com.example.dummydictionary.data.model.Word


class DictionaryRepository(
    private val wordDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
)  {

    fun getAllWords() = wordDoa.getAllWords()

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}
