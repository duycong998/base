package com.datn.cookingguideapp.data.remote.interceptor

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nexlsoft.loginsample.data.local.AppPrefKey
import nexlsoft.loginsample.data.local.AppSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody

class InterceptorImpl(private val preferences: AppSharedPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = initializeRequestWithHeaders(chain.request())
        val response = chain.proceed(request)
        if (response.code == 401) preferences.clearKey(AppPrefKey.ACCESS_TOKEN)
        val responseBody = response.body
        val responseBodyString = response.body?.string()
        Log.d("====>log_response ${request.url}", responseBodyString ?: "")
        return createNewResponse(response, responseBody, responseBodyString)
    }

    private fun initializeRequestWithHeaders(request: Request): Request {
       /* val accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYzFiNDZjYTliMjc1YmQ5YTIxYWYiLCJpYXQiOjE2Njg1MzA2MTIsImV4cCI6MTY2ODYxNzAxMn0.rAf3u-F1Zuomy-ba68jxzeg3JHit_5D4Eb9k6UuNnBk"

        GlobalScope.launch {
            delay(1000)
            var accessToken = preferences.loadToken()
            Log.d("###","tokken:"+accessToken)

        }*/

    //    var accessToken = preferences.loadToken()
        var accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc2MDJhMTZjYTliMjc1YmQ5YTIxZGYiLCJpYXQiOjE2Njg2NzgzMDUsImV4cCI6MTY2ODc2NDcwNX0.gdcf7ktypebcXVo9xCBRUOyFK0gFOV8mywUNxgaqax8"
        Log.d("###","tokken:"+accessToken)
       // Log.d("###","tokken:"+accessToken)

        accessToken?.let { Log.d("====>log_request ${request.url}", it) }
        return request.newBuilder()
            .addHeader("Authorization", "Bearer $accessToken")
            .build()
    }

    private fun createNewResponse(
        response: Response,
        responseBody: ResponseBody?,
        responseBodyString: String?
    ): Response {
        val contentType = responseBody?.contentType()
        return response.newBuilder()
            .body((responseBodyString ?: "").toResponseBody(contentType))
            .build()
    }
}
