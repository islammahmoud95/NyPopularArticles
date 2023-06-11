package com.example.nypopulararticle.presentation.features.articales

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.presentation.ui.theme.BLACK
import com.example.nypopulararticle.presentation.ui.theme.GRAY
import com.example.nypopulararticle.presentation.ui.theme.WHITE
import com.example.nypopulararticle.R
import com.example.nypopulararticle.presentation.common.Progress
import com.example.nypopulararticle.presentation.ui.theme.GRAY_LIGHT
import com.example.nypopulararticle.presentation.ui.theme.Purple40

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesScreen(viewModel: ArticlesViewModel,onItemClicked: (ArticleResponse)-> Unit) {

    val mostPopular by viewModel.mostPopularObserver.observeAsState(initial = listOf())
    val loading by viewModel.loading.observeAsState(true)

    Scaffold(
        topBar = {
            ToolBar()
        },

        ) {

        Box(
            Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GRAY_LIGHT)
        ) {

            ArticleListItems(mostPopular,onItemClicked)
            if (loading)
                Progress(loading)

        }
    }

}


@ExperimentalMaterial3Api
@Composable
fun ArticleListItems(mostPopular: List<ArticleResponse>,onItemClicked: (ArticleResponse)-> Unit) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        items(mostPopular) {
            ItemList(it,onItemClicked)
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(GRAY)
            )

        }
    }


}

@ExperimentalMaterial3Api
@Composable
fun ItemList(mostPopular: ArticleResponse,onItemClicked: (ArticleResponse)-> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(WHITE).clickable {
                onItemClicked.invoke(mostPopular)
            }
    ) {
        val (image, title, source, date) = createRefs()

        AsyncImage(
            model = if (mostPopular.media?.isNotEmpty() == true)
                mostPopular.media[0].mediaMetadata?.find { it.height == "75" }?.url
            else "",
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start, 10.dp)
                }
                .width(75.dp)
                .height(75.dp)
        )

        Text(
            text = mostPopular.title ?: "",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = BLACK,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(title) {
                    top.linkTo(image.top)
                    start.linkTo(image.end, 10.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            textAlign = TextAlign.Start

        )
        Text(
            text = mostPopular.source ?: "",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = GRAY,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(source) {
                    top.linkTo(title.bottom, 5.dp)
                    start.linkTo(title.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                },
            textAlign = TextAlign.Start

        )


        Text(
            text = "Published at :".plus(" ").plus(mostPopular.publishedDate ?: ""),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = GRAY,
            modifier = Modifier
                .constrainAs(date) {
                    top.linkTo(source.bottom, 5.dp)
                    end.linkTo(parent.end,10.dp)
                    bottom.linkTo(parent.bottom, 10.dp)
                },
            textAlign = TextAlign.Start

        )

    }
}

@ExperimentalMaterial3Api
@Composable
fun ToolBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Purple40
            )

        },
        Modifier.background(WHITE),
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ItemListPreview() {
    ItemList(ArticleResponse(),{})
}
