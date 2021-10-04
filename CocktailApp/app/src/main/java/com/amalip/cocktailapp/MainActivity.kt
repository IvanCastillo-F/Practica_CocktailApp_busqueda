package com.amalip.cocktailapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.amalip.cocktailapp.core.presentation.BaseActivity
import com.amalip.cocktailapp.databinding.ActivityMainBinding
import com.amalip.cocktailapp.databinding.CocktailFragmentBinding
import com.amalip.cocktailapp.presentation.cocktails.CocktailFragment
import com.squareup.moshi.Moshi
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun layoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
    }

    override val fragmentContainer: FragmentContainerView
        get() = binding.fcv

    override fun setUpNavigation(navController: NavController) =
        NavigationUI.setupWithNavController(binding.bnvMain, navController)

    override fun showProgress(show: Boolean) {
        binding.progressView.isVisible = show
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
    }


}