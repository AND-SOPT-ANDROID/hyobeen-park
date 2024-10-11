package org.sopt.and.core.designsystem.component.topappbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import org.sopt.and.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CloseButtonTopAppBar(
    title: String,
    onCloseClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black),
        title = {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.White,
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_close_24),
                contentDescription = stringResource(R.string.sign_up_main_title),
                tint = Color.White,
                modifier = Modifier
                    .clickable { onCloseClick() }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
        )
    )
}
