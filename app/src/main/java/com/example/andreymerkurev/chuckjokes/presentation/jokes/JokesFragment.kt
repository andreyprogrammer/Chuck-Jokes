package com.example.andreymerkurev.chuckjokes.presentation.jokes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.andreymerkurev.chuckjokes.App
import com.example.andreymerkurev.chuckjokes.R
import com.example.andreymerkurev.chuckjokes.databinding.FragmentJokesBinding
import com.example.andreymerkurev.chuckjokes.presentation.jokes.adapter.JokesRecyclerViewAdapter
import javax.inject.Inject

class JokesFragment : Fragment() {

    @Inject
    lateinit var jokesViewModelFactory: JokesViewModelFactory

    val jokesViewModel: JokesViewModel by viewModels {
        jokesViewModelFactory
    }

    private lateinit var binding: FragmentJokesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireNotNull(this.activity).application as App).appComponent.inject(this)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_jokes, container, false
        )
        binding.jokesViewModel = jokesViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = JokesRecyclerViewAdapter()

        binding.btnReload.setOnClickListener {
            btnReloadClick(binding.input.text.toString())
            requireActivity().window
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }

        jokesViewModel.status.observe(viewLifecycleOwner) { status ->
            if (status == JokesViewModel.Status.ERROR)
                Toast.makeText(requireContext(), "An error occurred", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun btnReloadClick(count: String) {
        jokesViewModel.getJokes(count)
    }
}