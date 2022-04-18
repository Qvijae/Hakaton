package com.example.hakaton.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hakaton.databinding.EditRequestFragmentBinding
import com.example.hakaton.viewmodels.EditRequestViewModel

class EditRequestFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = EditRequestFragmentBinding.inflate(layoutInflater)

        binding.viewModel = EditRequestViewModel()

        return binding.root
    }
}