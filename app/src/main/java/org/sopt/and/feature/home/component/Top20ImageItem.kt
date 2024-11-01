package org.sopt.and.feature.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.core.designsystem.component.image.WavveAsyncImage

@Composable
fun Top20ImageItem(
    image: String,
    rank: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
    ) {
        WavveAsyncImage(
            imageUrl = image,
            cornerRadius = 10.dp,
            modifier = Modifier
                .padding(bottom = 30.dp)
                .size(height = 260.dp, width = 180.dp),
        )
        Text(
            text = rank.toString(),
            fontSize = 50.sp,
            color = White,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}