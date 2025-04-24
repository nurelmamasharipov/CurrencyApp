package com.example.currencyapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()
    private lateinit var ratesAdapter: RatesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchRates()

        viewModel.rates.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                Log.d("ololo", "Rates: ${response.body()?.conversion_rates}")
            } else {
                Log.e("ololo", "Error: ${response.message()}")
            }
        }
        ratesAdapter = RatesAdapter()
        binding.ratesRecyclerView.adapter = ratesAdapter

        viewModel.fetchRates()

        viewModel.rates.observe(viewLifecycleOwner) { response ->
            if (response.isSuccessful) {
                response.body()?.conversion_rates?.let { rates ->
                    ratesAdapter.setRates(rates)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}