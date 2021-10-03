package com.amalip.cocktailapp.core.presentation

import com.amalip.cocktailapp.core.exception.Failure

/**
 * Created by Amalip on 9/29/2021.
 */

interface OnFailure {

    fun handleFailure(failure: Failure?)

}