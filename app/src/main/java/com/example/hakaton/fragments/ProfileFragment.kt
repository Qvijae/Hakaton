package com.example.hakaton.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hakaton.databinding.ProfileFragmentBinding
import com.example.hakaton.viewmodels.ProfileViewModel

class ProfileFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = ProfileFragmentBinding.inflate(layoutInflater)

        binding.viewModel = ProfileViewModel()

        return binding.root
    }
}