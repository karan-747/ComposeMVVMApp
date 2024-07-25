package com.testers.unique.tweetsyapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.testers.unique.tweetsyapp.R
import com.testers.unique.tweetsyapp.models.TweetItem
import com.testers.unique.tweetsyapp.viewmodels.CategoriesViewModel
import com.testers.unique.tweetsyapp.viewmodels.DetailViewModel


@Composable
fun DetailScreen() {
    val detailViewModel: DetailViewModel = hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()

    LazyColumn(

    ) {
        items(tweets.value) {
            com.testers.unique.tweetsyapp.screens.TweetItem(tweet = it.tweet)
        }
    }
}

@Composable
fun TweetItem(tweet: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color.DarkGray)
    ) {
        Text(
            text = tweet,
            fontSize = 16.sp,
            modifier=Modifier.padding(3.dp)
        )
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTweetItem() {
    TweetItem("Just discovered a cool new Android app that tracks my daily steps and motivates me to walk more! #AndroidLife #FitnessApp")
}