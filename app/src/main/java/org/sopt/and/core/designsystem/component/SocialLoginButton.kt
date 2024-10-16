package org.sopt.and.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme

val snsImageList = listOf(
    R.drawable.img_kakao_logo,
    R.drawable.img_skt_logo,
    R.drawable.img_naver_logo,
    R.drawable.img_facebook_logo,
)

@Composable
fun SocialLoginButton(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        for (index in 0..3) {
            Image(
                painter = painterResource(snsImageList[index]),
                contentDescription = stringResource(R.string.img_social_login),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clip(shape = CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SocialLoginButtonPreview() {
    ANDANDROIDTheme {
        SocialLoginButton()
    }
}