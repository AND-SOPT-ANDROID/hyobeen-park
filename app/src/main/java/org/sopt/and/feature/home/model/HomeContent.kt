package org.sopt.and.feature.home.model

import androidx.annotation.StringRes
import org.sopt.and.R

data class HomeContent(
    @StringRes val title: Int,
    val contentList: List<String>,
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
