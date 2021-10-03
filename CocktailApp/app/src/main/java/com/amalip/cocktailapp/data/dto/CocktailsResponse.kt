package com.amalip.cocktailapp.data.dto

import com.amalip.cocktailapp.domain.model.Cocktail
import com.squareup.moshi.JsonClass

/**
 * Created by Amalip on 9/29/2021.
 */

@JsonClass(generateAdapter = true)
data class CocktailsResponse(val drinks: List<Cocktail>? = listOf())
