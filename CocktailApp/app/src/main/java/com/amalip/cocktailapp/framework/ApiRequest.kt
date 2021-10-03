package com.amalip.cocktailapp.framework

import com.amalip.cocktailapp.core.exception.Failure
import com.amalip.cocktailapp.core.functional.Either
import com.amalip.cocktailapp.core.plataform.NetworkHandler
import retrofit2.Call
import java.lang.Exception

/**
 * Created by Amalip on 9/29/2021.
 */

interface ApiRequest {

    fun <T, R> makeRequest(
        networkHandler: NetworkHandler,
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return when(networkHandler.isConnected) {
            true -> {
                try {
                    val response = call.execute()
                    when (response.isSuccessful) {
                        true -> Either.Right(transform(response.body() ?: default))
                        false -> Either.Left(Failure.ServerError(500, ""))
                    }
                } catch (e: Exception) {
                    Either.Left(Failure.ServerError(500, e.message))
                }
            }
            false -> Either.Left(Failure.NetworkConnection)
        }
    }

}