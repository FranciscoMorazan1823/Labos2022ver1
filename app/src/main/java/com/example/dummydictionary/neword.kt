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
import com.example.dummydictionary.databinding.FragmentNewordBinding
import com.example.dummydictionary.databinding.FragmentWordListBinding
import com.example.dummydictionary.ui.WordViewModel
import com.example.dummydictionary.ui.WordViewModelFactory

class neword : Fragment() {


    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())


    }
    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }


    private lateinit var binding: FragmentNewordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_neword, container, false)
        return binding.root
        // Inflate the layout for this fragment

        val navController = findNavController()
        val action = newordDirections.actionNewordToWordListFragment()

        binding.actionAddNword.setOnClickListener{

            viewModel.addWord(Word("","",false))

            navController.navigate(action)
        }
    }





}