package org.sopt.and.feature.home

import org.sopt.and.feature.home.model.HomeContent
import org.sopt.and.feature.home.model.HomeSliderImage
import org.sopt.and.feature.home.model.getHomeContent
import org.sopt.and.feature.home.model.getHomeSliderImage
import org.sopt.and.feature.home.model.getHomeTop20Image

data class HomeState(
    val pagerImageList: List<HomeSliderImage> = getHomeSliderImage(),
    val homeContentList: List<HomeContent> = getHomeContent(),
    val top20List: List<String> = getHomeTop20Image()
)