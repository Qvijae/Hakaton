package com.example.hakaton.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hakaton.databinding.ProfileFragmentBinding
import com.example.hakaton.databinding.RequestsFragmentBinding
import com.example.hakaton.viewmodels.ProfileViewModel
import com.example.hakaton.viewmodels.RequestViewModel

class RequestFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = RequestsFragmentBinding.inflate(layoutInflater)

        binding.viewModel = RequestViewModel()

        return binding.root
    }
}