package com.amalip.cocktailapp.core.presentation

/**
 * Created by Amalip on 9/29/2021.
 */

abstract class BaseViewState {

    object ShowLoading : BaseViewState()
    object HideLoading : BaseViewState()

}