package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun EmailTextField(
    email: String,
    hint: String,
    onValueChange: (String) -> Unit,
    cursorBrush: Brush = SolidColor(Color.White),
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current

    WavveBasicTextField(
        value = email,
        hint = hint,
        onValueChange = onValueChange,
        cursorBrush = cursorBrush,
        imeAction = ImeAction.Next,
        onNextAction = {
            focusManager.moveFocus(FocusDirection.Down)
        },
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color.DarkGray),
    )
}