package com.akshat.walmartdemo.utils

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

abstract class SafeAPIRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        val response = call.invoke()

        if (response.isSuccessful) {
            /*if(response.body()=="200")
                authListener?.onSuccessAPi(response.body()?.data!!)
            else
                authListener?.onFailure(response.body()?.message!!)*/

            return response.body()!!
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            message.append("Error Code :${response.code()}")
            throw ApiExceptions(message.toString())
        }
    }
}