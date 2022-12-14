package com.akshat.walmartdemo.ui

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshat.walmartdemo.R
import com.akshat.walmartdemo.adapter.CountriesRecyclerViewAdapter
import com.akshat.walmartdemo.network.CountriesAPI
import com.akshat.walmartdemo.repository.CountiresRepository
import com.akshat.walmartdemo.utils.ConnectionDetector
import com.akshat.walmartdemo.utils.alertDialog
import com.akshat.walmartdemo.utils.dismissprogressDialog
import com.akshat.walmartdemo.utils.showprogressDialog
import com.akshat.walmartdemo.viewmodel.CountriesViewModel
import com.akshat.walmartdemo.viewmodel.CountriesViewModelFactory

class CountriesActivity : AppCompatActivity() {
    private lateinit var factory: CountriesViewModelFactory
    private lateinit var viewModel: CountriesViewModel
    private lateinit var cd: ConnectionDetector


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_countries)
        cd = ConnectionDetector()
        val api = CountriesAPI()
        val repository = CountiresRepository()
        factory = CountriesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(CountriesViewModel::class.java)
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view_data)


        if (cd.isConnectingToInternet(this)) {
            showprogressDialog(
                this@CountriesActivity,
                resources.getString(R.string.home_message),
                "",
                true
            )

            viewModel.getCountriesData()
            viewModel.providedData.observe(this, Observer { providedData ->
                recyclerview.also {
                    it.layoutManager = LinearLayoutManager(this)
                    it.setHasFixedSize(true)
                    if (providedData != null) {
                        dismissprogressDialog(this)
                    }
                    it.adapter = CountriesRecyclerViewAdapter(providedData)
                }

            })
        } else {
            alertDialog(resources.getString(R.string.no_internet_string))
        }

    }
}