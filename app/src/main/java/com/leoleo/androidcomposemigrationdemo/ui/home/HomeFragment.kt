package com.leoleo.androidcomposemigrationdemo.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.leoleo.androidcomposemigrationdemo.R
import com.leoleo.androidcomposemigrationdemo.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        val myAdapter = MyListAdapter()
        binding.userList.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(false)
        }

        binding.button.setOnClickListener {
            homeViewModel.getUsers()
        }

        homeViewModel.uiState.observe(viewLifecycleOwner) {

            binding.userList.isVisible = when (it) {
                is Data -> true
                else -> false
            }
            binding.loading.isVisible = when (it) {
                Loading -> true
                else -> false
            }
            binding.errorMessage.isVisible = when (it) {
                is Error -> true
                else -> false
            }

            when (it) {
                is Data -> myAdapter.submitList(it.users)
                is Error -> binding.errorMessage.text = it.message
                Initial -> {}
                Loading -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

