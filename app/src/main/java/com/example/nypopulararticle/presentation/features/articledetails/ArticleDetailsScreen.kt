package com.example.nypopulararticle.presentation.features.articledetails

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.nypopulararticle.NYArticalApp
import com.example.nypopulararticle.domain.model.ArticleResponse
import com.example.nypopulararticle.presentation.ui.theme.BLACK
import com.example.nypopulararticle.presentation.ui.theme.GRAY
import com.example.nypopulararticle.presentation.ui.theme.WHITE
import com.example.nypopulararticle.R
import com.example.nypopulararticle.presentation.common.Progress
import com.example.nypopulararticle.presentation.ui.theme.GRAY_LIGHT
import com.example.nypopulararticle.presentation.ui.theme.Pink40
import com.example.nypopulararticle.presentation.ui.theme.Purple40

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesDetailsScreen(viewModel: ArticlesDetailsViewModel,onBackPressed:()->Unit) {

    val mostPopular by viewModel.mostPopularObserver.observeAsState(initial = ArticleResponse())

    Scaffold(
        topBar = {
            ToolBar(onBackPressed)
        },

        ) {

        Column(
            Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GRAY_LIGHT)
        ) {

            ArticleItem(mostPopular)

        }
    }

}


@ExperimentalMaterial3Api
@Composable
fun ArticleItem(mostPopular:ArticleResponse) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        item {
            Column(
                modifier=Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = if (mostPopular.media?.isNotEmpty() == true)
                        mostPopular.media[0].mediaMetadata?.find { it.height == "293" }?.url
                    else "",
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = mostPopular.title ?: "",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = BLACK,
                    modifier = Modifier
                        .fillMaxWidth().padding(start=10.dp,top=10.dp),
                    textAlign = TextAlign.Start

                )
                Text(
                    text = mostPopular.source ?: "",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = GRAY,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxWidth().padding(start=10.dp,top=10.dp),
                    textAlign = TextAlign.Start

                )


                Text(
                    text = "Published at :".plus(" ").plus(mostPopular.publishedDate ?: ""),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = GRAY,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth().padding(start=10.dp,top=10.dp),
                    )
                 Text(
                    text = "KeyWords : ".plus(mostPopular.adx_keywords.toString()),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    color = BLACK,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth().padding(start=10.dp,top=10.dp),

                    )

                Text(
                    text = "Abstract : ".plus(mostPopular.abstract.toString()),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    color = BLACK,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth().padding(start=10.dp,top=10.dp),
                    )

                Text(
                    text = "Article link : ".plus(mostPopular.url.toString()),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Normal,
                    color = Pink40,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth().padding(start=10.dp,top=10.dp)
                        .clickable {
                            val intent = Intent(Intent.ACTION_VIEW, mostPopular.url?.toUri())
                            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
                            ContextCompat.startActivity( NYArticalApp.application,intent,null)
                        },
                    textDecoration = TextDecoration.Underline
                    )


            }

        }
    }


}

@ExperimentalMaterial3Api
@Composable
fun ToolBar(onBackPressed:()->Unit) {
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
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun ItemListPreview() {
    ArticleItem(ArticleResponse(title = "islam test"))
}
