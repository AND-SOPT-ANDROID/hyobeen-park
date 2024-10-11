package org.sopt.and.feature.mypage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.and.R
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme
import org.sopt.and.feature.mypage.component.MyPageContent
import org.sopt.and.feature.mypage.component.MyPageTextButton
import org.sopt.and.feature.signin.ID_KEY

@AndroidEntryPoint
class MyPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val email = intent.getStringExtra(ID_KEY) ?: ""

        super.onCreate(savedInstanceState)
        setContent {
            ANDANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    MyPageScreen(
                        email = email,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyPageScreen(
    email: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(Color.Black)
            .fillMaxSize(),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .padding(horizontal = 20.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 10.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .size(55.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = stringResource(R.string.my_page_name, email),
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .weight(1f),
                )
                Icon(
                    painter = painterResource(R.drawable.ic_notifications_24),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 20.dp)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_settings_24),
                    contentDescription = "",
                    tint = Color.White,
                )
            }

            MyPageTextButton(
                content = stringResource(R.string.my_page_purchase_content_1),
                onButtonClick = {},
            )
        }

        MyPageTextButton(
            content = stringResource(R.string.my_page_purchase_content_2),
            onButtonClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp)
                .background(Color.DarkGray)
                .padding(horizontal = 20.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp),
        ) {
            MyPageContent(
                title = stringResource(R.string.my_page_title_1),
                content = stringResource(R.string.my_page_content_1)
            )
            MyPageContent(
                title = stringResource(R.string.my_page_title_2),
                content = stringResource(R.string.my_page_content_2)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPagePreview(

) {
    ANDANDROIDTheme {
        MyPageScreen("")
    }
}