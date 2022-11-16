package com.datn.cookingguideapp.data.remote.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import java.util.*

class InterceptorImpl : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = initializeRequestWithHeaders(chain.request())
        val response = chain.proceed(request)
        val responseBody = response.body
        val responseBodyString = response.body?.string()
        Log.d("====>log_response ${request.url}", responseBodyString ?: "")
        return createNewResponse(response, responseBody, responseBodyString)
    }

    private fun initializeRequestWithHeaders(request: Request): Request {
        val accessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczYzFiNDZjYTliMjc1YmQ5YTIxYWYiLCJpYXQiOjE2Njg1MzA2MTIsImV4cCI6MTY2ODYxNzAxMn0.rAf3u-F1Zuomy-ba68jxzeg3JHit_5D4Eb9k6UuNnBk"
        Log.d("====>log_request ${request.url}", request.body.toString())
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
