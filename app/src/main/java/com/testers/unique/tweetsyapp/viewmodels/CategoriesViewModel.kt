package com.testers.unique.tweetsyapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.testers.unique.tweetsyapp.models.TweetItem
import com.testers.unique.tweetsyapp.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoriesViewModel  @Inject constructor(
    private val repository: TweetRepository
) :ViewModel() {

    val categories :StateFlow<List<String>>
        get()  = repository.categories
    init{
        viewModelScope.launch {
            repository.getCategories()
        }

    }


}