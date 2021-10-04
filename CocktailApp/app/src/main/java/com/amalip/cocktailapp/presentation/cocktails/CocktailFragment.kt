package com.amalip.cocktailapp.presentation.cocktails

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalip.cocktailapp.R
import com.amalip.cocktailapp.core.extension.failure
import com.amalip.cocktailapp.core.extension.observe
import com.amalip.cocktailapp.core.presentation.BaseFragment
import com.amalip.cocktailapp.core.presentation.BaseViewState
import com.amalip.cocktailapp.databinding.ActivityMainBinding
import com.amalip.cocktailapp.databinding.CocktailFragmentBinding
import com.amalip.cocktailapp.domain.model.Cocktail
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class CocktailFragment : BaseFragment(R.layout.cocktail_fragment) {

    private lateinit var binding: CocktailFragmentBinding
    private lateinit var adapter: CocktailAdapter
    private lateinit var adapterGrid: CocktailAdapterGridLayout
    private val cocktailViewModel by viewModels<CocktailViewModel>()
    private var grid = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cocktailViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)

            doGetCocktailsByName("margarita")

        }

    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is CocktailViewState.CocktailsReceived -> setUpAdapter(state.cocktails)
        }
    }


    private fun setUpAdapter(cocktails: List<Cocktail>) {
        adapter = CocktailAdapter()
        adapterGrid = CocktailAdapterGridLayout()

        if(cocktails.isEmpty()){

        }
        adapter.addData(cocktails)
        adapterGrid.addData(cocktails)

        binding.rcCocktails.apply {
            adapter = this@CocktailFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = CocktailFragmentBinding.bind(view)

        binding.svCocktail.setOnQueryTextListener(searchListener)

        binding.swButton.setOnClickListener(){
            if (grid){

                binding.rcCocktails.apply {
                    adapter = this@CocktailFragment.adapter
                }

                binding.rcCocktails.layoutManager = LinearLayoutManager(requireContext())

            }else{

               binding.rcCocktails.apply {
                    adapter = this@CocktailFragment.adapterGrid
                }

                binding.rcCocktails.layoutManager = GridLayoutManager(requireContext() ,3)
            }
            grid = !grid
        }

        /* val gridManager = GridLayoutManager(requireContext() ,3, GridLayoutManager.VERTICAL,false)

        binding.rcCocktails.layoutManager = gridManager*/



        binding.lifecycleOwner = this
    }

    private fun showMessege(message: String) = Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

    private val searchListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
            binding.rcCocktails.layoutManager = LinearLayoutManager(requireContext())
            cocktailViewModel.apply{

                if(p0.toString() == ""){ doGetCocktailsByName("margarita") }
                else{   doGetCocktailsByName(p0.toString())  }

            }
            return true
        }

        override fun onQueryTextChange(p0: String?): Boolean {
            binding.rcCocktails.layoutManager = LinearLayoutManager(requireContext())
            cocktailViewModel.apply{

                if(p0.toString() == ""){ doGetCocktailsByName("margarita") }
                else{   doGetCocktailsByName(p0.toString())  }

            }
            return true
        }
    }


}