package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.sopt.and.R

@Composable
fun PasswordTextField(
    password: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onDoneAction: () -> Unit,
    cursorBrush: Brush = SolidColor(Color.White),
    modifier: Modifier = Modifier,
) {
    val focusManager = LocalFocusManager.current
    var isPasswordVisible by remember { mutableStateOf(false) }

    WavveBasicTextField(
        value = password,
        hint = hint,
        onValueChange = onValueChange,
        onDoneAction = {
            focusManager.clearFocus()
            onDoneAction()
        },
        imeAction = ImeAction.Done,
        cursorBrush = cursorBrush,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        rightIcon = {
            Text(
                text = stringResource(
                    if (isPasswordVisible) R.string.password_textfield_hide
                    else R.string.password_textfield_show
                ),
                modifier = Modifier
                    .clickable {
                        isPasswordVisible = !isPasswordVisible
                    }
                    .padding(end = 10.dp),
                color = Color.White,
            )
        },
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Color.DarkGray),
    )
}