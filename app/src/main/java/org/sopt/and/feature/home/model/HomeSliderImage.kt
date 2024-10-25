package org.sopt.and.feature.home.model

data class HomeSliderImage(
    val title: String,
    val image: String,
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