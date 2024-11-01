package org.sopt.and.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R

@Composable
fun HomeTopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 15.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.img_main_logo),
            contentDescription = stringResource(R.string.wavve),
            modifier = Modifier
                .width(100.dp),
        )
        Icon(
            painter = painterResource(R.drawable.ic_live_tv_24),
            contentDescription = stringResource(R.string.wavve),
            tint = Color.White,
        )
    }
}