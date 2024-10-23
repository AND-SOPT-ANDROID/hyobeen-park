package org.sopt.and.feature.mypage.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.R

@Composable
fun MyPageContent(
    title: String,
    content: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(vertical = 20.dp),
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
        )
        Icon(
            painter = painterResource(R.drawable.ic_info_24),
            contentDescription = "",
            tint = Color.Gray,
            modifier = Modifier
                .padding(top = 50.dp)
                .size(80.dp)
        )

        Text(
            text = content,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 20.dp)
        )
    }
}