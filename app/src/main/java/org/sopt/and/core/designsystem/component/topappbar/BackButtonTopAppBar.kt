package org.sopt.and.core.designsystem.component.topappbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.sopt.and.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButtonTopAppBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Black),
        title = {
            Image(
                painter = painterResource(R.drawable.img_main_logo),
                contentDescription = stringResource(R.string.sign_in),
                modifier = Modifier
                    .width(100.dp)
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_left_24),
                contentDescription = stringResource(R.string.sign_in),
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .clickable { onBackClick() }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
        )
    )
}