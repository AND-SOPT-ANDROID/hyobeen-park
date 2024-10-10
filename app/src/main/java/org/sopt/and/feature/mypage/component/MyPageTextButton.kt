package org.sopt.and.feature.mypage.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R

@Composable
fun MyPageTextButton(
    content: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(vertical = 15.dp)
            .clickable { onButtonClick() }
    ) {
        Text(
            text = content,
            fontSize = 16.sp,
            color = Color.Gray,
        )
        Row {
            Text(
                text = stringResource(R.string.my_page_purchase),
                fontSize = 16.sp,
                color = Color.White,
            )
            Icon(
                painter = painterResource(R.drawable.ic_arrow_right_24),
                contentDescription = stringResource(R.string.my_page_purchase),
                tint = Color.White,
            )
        }
    }
}
