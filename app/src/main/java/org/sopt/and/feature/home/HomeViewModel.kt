package org.sopt.and.feature.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.and.R
import org.sopt.and.feature.home.model.HomeContent
import org.sopt.and.feature.home.model.HomeSliderImage
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val homeState get() = _homeState.asStateFlow()
}

fun getHomeTop20Image(): List<String> = listOf(
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202309/1694062313324743958.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1726468463104944317.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202311/1698908212143109040.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202410/1728017508965610221.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202311/1700742608486397915.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202311/1699601586197251349.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202307/1690523370531767356.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202307/1688707846915136240.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202405/1715069627941981919.webp",
    "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202410/1728613201561457273.webp",
)

fun getHomeSliderImage(): List<HomeSliderImage> = listOf(
    HomeSliderImage(
        title = "",
        image = "https://image.wavve.com/v1/thumbnails/240_360_20_80/BMS/program_poster/202112/F3901_F39000000006-2.webp"
    ),
    HomeSliderImage(
        title = "",
        image = "https://i.namu.wiki/i/qYSZ5gR-NfhHVev02-wh_s2mnB2jSmV7fZwv8iqVDdwUhYSiwRqP0spZDR_zyQS0FydkWNX7aTxqYbhsBTcKZg.webp"
    ),
    HomeSliderImage(
        title = "",
        image = "https://www.chosun.com/resizer/v2/HRGER65PGPIW36FJOBRNAP2PJM.jpg?auth=9da0c167de2cfb03a5d344ce4098faa669a22d7a2b90cb6a21fdc518b0af3558&width=530&height=757&smart=true"
    ),
    HomeSliderImage(
        title = "",
        image = "https://img.imbc.com/adams/Program/20149/130552234491328038.jpg"
    ),
    HomeSliderImage(
        title = "",
        image = "https://i.namu.wiki/i/Up0fqwVo0924M6yoE9DInupC4_D0Jgon10AUN4Up3XgwtgLe96wQ3aqMDnwyntpD174HobyE91BEt8G33JTa1Q.webp"
    ),
)

fun getHomeContent(): List<HomeContent> = listOf(
    HomeContent(
        title = R.string.home_editor_recommend,
        contentList = listOf(
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202410/1728609264868811411.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1727073001312600950.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1726468505828994516.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202410/1728548543503727711.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1727679685902220639.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/BMS/TVSeason/2023/C9901_C99000000062-Vertical_LogoY_WOriginal.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1727416060204368451.webp",
        )
    ),
    HomeContent(
        title = R.string.home_trending_now,
        contentList = listOf(
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202307/1688707856348829500.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1726129999639023816.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202309/1694678603909348772.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1727255007631341114.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202309/1694062320658347760.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202305/1683859424490303614.webp",
            "https://image.wavve.com/v1/thumbnails/240_360_20_80/meta/image/202409/1726468505828994516.webp",
        )
    ),
)

val homeCategory: List<Int> = listOf(
    R.string.new_classic,
    R.string.drama,
    R.string.entertainment,
    R.string.film,
    R.string.animation,
    R.string.abroad_series,
    R.string.current_affairs,
    R.string.kids,
    R.string.film_plus,
)