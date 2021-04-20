package uca.edu.brawlcharacters.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uca.edu.brawlcharacters.R
import uca.edu.brawlcharacters.intent.Intent
import uca.edu.brawlcharacters.ui.MainViewModel
import uca.edu.brawlcharacters.utils.AdapterBrawlers
import uca.edu.brawlcharacters.utils.DataState
import javax.inject.Inject


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor() : Fragment(R.layout.fragment_first) {
    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var adapterBrawlers: AdapterBrawlers

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        val layoutManager =
            LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewPlaces.layoutManager = layoutManager
        recyclerViewPlaces.adapter = adapterBrawlers

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetBrawlerEvent)
        }
    }

    private fun subscribeObservers(){
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when(it){
                    is DataState.Success -> {
                        displayProgressBar(false)
                        adapterBrawlers.setPlaces(it.brawler)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        //  if (message != null) text.text = message else text.text = "Unknown error."
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}