package org.sopt.and.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import kotlinx.coroutines.delay
import org.sopt.and.feature.home.model.HomeSliderImage

@Composable
fun HomeImageSlider(
    images: List<HomeSliderImage>,
    modifier: Modifier = Modifier,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val imageCount = images.size
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { Int.MAX_VALUE },
    )

    val autoScroll = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        if (autoScroll.value) {
            while (true) {
                delay(4000)
                if (!pagerState.isScrollInProgress) {
                    val nextPage = pagerState.currentPage.plus(1)
                    pagerState.animateScrollToPage(nextPage)
                }
            }
        }
    }

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = screenWidth * 0.1f / 2),
        beyondViewportPageCount = 1,
        modifier = modifier
    ) { page ->
        val currentPage = page % imageCount
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(images[currentPage].image)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(480.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(
                        end = 10.dp,
                        bottom = 10.dp
                    )
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Black)
            ) {
                Text(
                    text = currentPage.plus(1).toString(),
                    fontSize = 10.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 5.dp),
                )
                VerticalDivider(
                    thickness = 1.dp,
                    color = Color.DarkGray,
                    modifier = Modifier
                        .height(10.dp)
                        .padding(horizontal = 3.dp),
                )
                Text(
                    text = imageCount.toString(),
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(end = 5.dp),
                )
            }
        }
    }
}