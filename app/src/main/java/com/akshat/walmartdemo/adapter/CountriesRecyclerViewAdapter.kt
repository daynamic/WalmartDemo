package com.akshat.walmartdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.akshat.walmartdemo.R
import com.akshat.walmartdemo.databinding.LayoutBinding
import com.akshat.walmartdemo.model.ResponseItem

class CountriesRecyclerViewAdapter(
    private val countriesAvailable: List<ResponseItem>,
) : RecyclerView.Adapter<CountriesRecyclerViewAdapter.CountriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountriesViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout,
            parent,
            false
        )
    )

    override fun getItemCount() = countriesAvailable.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) {
        holder.recyclerViewCountriesBinding.countries = countriesAvailable[position]
    }


    inner class CountriesViewHolder(
        val recyclerViewCountriesBinding: LayoutBinding
    ) : RecyclerView.ViewHolder(recyclerViewCountriesBinding.root)


}