package com.example.currencyapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.databinding.ItemRateBinding

class RatesAdapter : RecyclerView.Adapter<RatesAdapter.RateViewHolder>() {

    private val ratesList = mutableListOf<Pair<String, Double>>()

    @SuppressLint("NotifyDataSetChanged")
    fun setRates(newRates: Map<String, Double>) {
        ratesList.clear()
        ratesList.addAll(newRates.toList())
        notifyDataSetChanged()
    }

    inner class RateViewHolder(private val binding: ItemRateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(rate: Pair<String, Double>) {
            binding.tvCurrencyCode.text = rate.first
            binding.tvCurrencyRate.text = rate.second.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val binding = ItemRateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(ratesList[position])
    }

    override fun getItemCount(): Int = ratesList.size
}
