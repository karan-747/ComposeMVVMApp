package com.testers.unique.tweetsyapp.api

import com.testers.unique.tweetsyapp.models.TweetItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("v3/b/669fe430e41b4d34e41607be?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<TweetItem>>

    @GET("v3/b/669fe430e41b4d34e41607be?meta=false")
    @Headers("X-JSON-Path:$..category")
    suspend fun getCategories():Response<List<String>>

    @GET("v3/b/669fe430e41b4d34e41607be?meta=false")
    suspend fun getAllTweets() : Response<List<TweetItem>>

}