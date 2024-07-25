package com.testers.unique.tweetsyapp.repository

import android.util.Log
import com.testers.unique.tweetsyapp.api.TweetsyApi
import com.testers.unique.tweetsyapp.models.TweetItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(
    private val tweetsyApi: TweetsyApi
) {
    private var _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String> >
        get ()= _categories

    private var _tweets = MutableStateFlow<List<TweetItem>>(emptyList())
    val tweets: StateFlow<List<TweetItem> >
        get ()= _tweets

    suspend fun getTweets(category:String){
        val result= tweetsyApi.getTweets("\$..[?(@.category==\"${category}\")]")
        if(result.isSuccessful && result.body()!=null){
            _tweets.emit(result.body()!!)
        }
    }


    suspend fun getCategories(){
        val result= tweetsyApi.getCategories()
        Log.d("APICHECK",result.body()?.size.toString())
        if(result.isSuccessful && result.body()!=null){
            _categories.emit(result.body()!!)
        }
    }
}