package com.amalip.cocktailapp.core.plataform

import android.content.Context
import com.amalip.cocktailapp.core.extension.networkInfo
import javax.inject.Inject

/**
 * Created by Amalip on 9/29/2021.
 */

class NetworkHandler @Inject constructor(private val context: Context) {

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true

}