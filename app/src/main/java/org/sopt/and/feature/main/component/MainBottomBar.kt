package org.sopt.and.feature.main.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.and.feature.main.MainTab

@Composable
fun MainBottomBar(
    tabs: List<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    NavigationBar(containerColor = Color.Black) {
        tabs.forEach { itemType ->
            NavigationBarItem(
                selected = currentTab == itemType,
                onClick = {
                    onTabSelected(itemType)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = (itemType.icon)),
                        contentDescription = stringResource(id = itemType.contentDescription),
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                },
                label = {
                    Text(
                        stringResource(id = itemType.contentDescription),
                        fontSize = 9.sp
                    )
                },
                colors = androidx.compose.material3.NavigationBarItemDefaults
                    .colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedIconColor = Color.LightGray,
                        unselectedTextColor = Color.LightGray,
                        indicatorColor = Color.Transparent
                    )
            )
        }
    }
}
