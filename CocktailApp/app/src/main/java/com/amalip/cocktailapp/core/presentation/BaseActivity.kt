package com.amalip.cocktailapp.core.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController

/**
 * Created by Amalip on 9/28/2021.
 */

abstract class BaseActivity : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract val fragmentContainer: FragmentContainerView

    abstract fun setUpNavigation(navController: NavController)

    abstract fun showProgress(show: Boolean)

    abstract fun setBinding()

}