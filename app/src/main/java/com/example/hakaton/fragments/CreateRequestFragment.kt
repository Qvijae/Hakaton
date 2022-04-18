package com.example.hakaton.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hakaton.databinding.CreateRequestFragmentBinding
import com.example.hakaton.viewmodels.CreateRequestViewModel

class CreateRequestFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = CreateRequestFragmentBinding.inflate(layoutInflater)

        binding.viewModel = CreateRequestViewModel()

        return binding.root
    }
}