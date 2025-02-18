package com.testers.unique.tweetsyapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.testers.unique.tweetsyapp.viewmodels.CategoriesViewModel


@Composable
fun CategoryScreen(onClick: (category:String)->Unit) {

    val categoryViewModel: CategoriesViewModel = hiltViewModel()
    val categories = categoryViewModel.categories.collectAsState()
    val l= categories.value.size
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        items(categories.value.distinct()) {
            CategoryItem(category = it,onClick)
        }
    }
}

@Composable
fun CategoryItem(category: String,onClick: (category:String)->Unit) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .paint(
                painterResource(id = R.drawable.polygon_scatter_haikei),
                contentScale = ContentScale.Crop
            )
            .border(1.dp, Color.LightGray)
            .clickable {
                   onClick(category)
            },

        contentAlignment = Alignment.BottomCenter

    ) {
        Text(
            text = category,
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 20.dp),
            style = MaterialTheme.typography.bodyMedium

        )
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCategoryItem() {
    CategoryItem("Android"){}
}