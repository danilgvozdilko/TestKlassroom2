package com.game.testklassroom2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.game.testklassroom2.databinding.FragmentMenuBinding
import com.game.testklassroom2.util.launchWhenStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding: FragmentMenuBinding
        get() = _binding!!

    private val viewModel: MenuViewModel by viewModels()
    private val postAdapter = PostsAdapter(onPageEndReached = {
        viewModel.onPageEndReached()
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = postAdapter
        observeViewModel()
    }

    private fun observeViewModel() {
        launchWhenStarted(viewModel.stateFlow) { state ->
            postAdapter.submitList(state.postList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}