package com.example.dummydictionary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dummydictionary.data.model.Word
import com.example.dummydictionary.databinding.FragmentWordListBinding
import com.example.dummydictionary.repository.DictionaryRepository
import com.example.dummydictionary.ui.WordAdapter
import com.example.dummydictionary.ui.WordViewModel
import com.example.dummydictionary.ui.WordViewModelFactory

class WordListFragment : Fragment() {


    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())


    }
    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }


    private lateinit var binding: FragmentWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_word_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val wordListRecyclerView = binding.wordListRecyclerView
        val wordAdapter = WordAdapter()
        wordListRecyclerView.apply {
            adapter = wordAdapter
        }
        viewModel.words.observe(viewLifecycleOwner) { data ->
            wordAdapter.setData(data)
        }

        val navController = findNavController()

        binding.actionTravel.setOnClickListener{

            val action = WordListFragmentDirections.actionWordListFragmentToNeword()
            navController.navigate(action)
        }

    }}






