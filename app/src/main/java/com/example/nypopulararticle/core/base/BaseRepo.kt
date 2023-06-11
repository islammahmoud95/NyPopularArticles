package com.example.nypopulararticle.core.base

import com.example.nypopulararticle.core.Resource
import com.example.nypopulararticle.domain.exceptions.ApiException
import com.example.nypopulararticle.domain.exceptions.GeneralException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
abstract class BaseRepo {

    // we'll use this function in all
    // repos to handle api errors.
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {

        // Returning api response
        // wrapped in Resource class
        return withContext(Dispatchers.IO) {
            try {

                // Here we are calling api lambda
                // function that will return response
                // wrapped in Retrofit's Response class
                val response: Response<T> = apiToBeCalled()

                if (response.isSuccessful) {
                    // In case of success response we
                    // are returning Resource.Success object
                    // by passing our data in it.
                    Resource.Success(data = response.body()!!)
                } else {
                    // parsing api's own custom json error
                    // response in ExampleErrorResponse pojo
                    val jsonObject = response.errorBody()?.string()?.let { JSONObject(it) }
//                    Timber.d("api_error_message==${jsonObject?.getString("message")}")
//                    Timber.d("api_error_status_code==${response.code()}")
//                    throw ApiException(msg = jsonObject?.getString("message") ?: "Something went wrong emad")

                    val exception = ApiException(
                        exceptionMsg = jsonObject?.getString("message") ?: "Something went wrong",
                        statusCode = jsonObject?.getInt("status_code")?:0, data = response.errorBody())
                    throw exception
                }

            } catch (e: HttpException) {
                // Returning HttpException's message
                // wrapped in Resource.Error
                throw GeneralException(msg = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                // Returning no internet message
                // wrapped in Resource.Error
                throw GeneralException("Please check your network connection")
                //  Resource.Error("Please check your network connection")
            } catch (e: Exception) {
                // Returning 'Something went wrong' in case
                // of unknown error wrapped in Resource.Error
                throw GeneralException(msg = "Something went wrong")
            }
        }
    }
}
