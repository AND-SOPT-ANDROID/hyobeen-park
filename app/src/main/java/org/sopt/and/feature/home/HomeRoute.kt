package org.sopt.and.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.sopt.and.R
import org.sopt.and.feature.home.component.HomeImageSlider
import org.sopt.and.feature.home.component.HomeTitleButton
import org.sopt.and.feature.home.component.HomeTopBar
import org.sopt.and.feature.home.component.Top20ImageItem
import org.sopt.and.feature.home.model.homeCategory

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.homeState.collectAsStateWithLifecycle()
    HomeScreen(
        paddingValues = paddingValues,
        homeState = homeState
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    homeState: HomeState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
            .fillMaxSize()
            .background(Color.Black),
    ) {
        item {
            HomeTopBar()
        }

        stickyHeader {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(Color.Black),
            ) {
                items(
                    count = homeCategory.size,
                    key = { item -> homeCategory[item] }
                ) { category ->
                    Text(
                        text = stringResource(homeCategory[category]),
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                    )

                }
            }
        }

        item {
            HomeImageSlider(
                images = homeState.pagerImageList
            )
        }

        items(
            count = homeState.homeContentList.size,
            key = { item -> homeState.homeContentList[item].title }
        ) { content ->
            with(homeState.homeContentList[content]) {
                HomeTitleButton(
                    title = stringResource(title),
                    modifier = Modifier
                        .padding(top = 10.dp),
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(horizontal = 15.dp)
                ) {
                    items(
                        count = contentList.size,
                        key = { item -> contentList[item] }
                    ) { image ->
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(contentList[image])
                                .crossfade(true)
                                .build(),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(width = 120.dp, height = 180.dp)
                                .clip(RoundedCornerShape(5.dp))
                        )
                    }
                }
            }
        }
        item {
            Column {
                Text(
                    text = stringResource(R.string.home_today_top_20),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 10.dp, bottom = 5.dp, start = 15.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(horizontal = 15.dp),
                ) {
                    with(homeState) {
                        items(
                            count = top20List.size,
                            key = { item -> top20List[item] }
                        ) { top20 ->
                            Top20ImageItem(
                                image = top20List[top20],
                                rank = top20 + 1,
                            )
                        }
                    }
                }
            }
        }
    }
}