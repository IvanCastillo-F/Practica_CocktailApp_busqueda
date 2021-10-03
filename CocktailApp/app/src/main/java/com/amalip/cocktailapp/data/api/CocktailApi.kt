package com.amalip.cocktailapp.data.api

import com.amalip.cocktailapp.data.dto.CocktailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Amalip on 9/29/2021.
 */

interface CocktailApi {

    @GET("json/v1/1/search.php")
    fun getCocktailsByName(@Query("s") name: String): Call<CocktailsResponse>

}