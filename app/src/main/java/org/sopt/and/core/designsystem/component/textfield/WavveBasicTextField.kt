package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.and.core.designsystem.theme.ANDANDROIDTheme

@Composable
fun WavveBasicTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    hint: String = "",
    cursorBrush: Brush,
    textColor: Color = Color.White,
    hintColor: Color = Color.Gray,
    maxLines: Int = 1,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leftIcon: Int? = null,
    leftIconColor: Color = Color.White,
    imeAction: ImeAction = ImeAction.Done,
    rightIcon: @Composable () -> Unit = {},
    onValueChange: (String) -> Unit = {},
    onDoneAction: () -> Unit? = {},
    onSearchAction: () -> Unit? = {},
    onNextAction: () -> Unit? = {},
) {
    BasicTextField(
        value = value,
        maxLines = maxLines,
        singleLine = true,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(imeAction = imeAction),
        keyboardActions = KeyboardActions(
            onDone = { onDoneAction() },
            onNext = { onNextAction() },
            onSearch = { onSearchAction() },
        ),
        modifier = modifier,
        cursorBrush = cursorBrush,
        textStyle = TextStyle.Default.copy(color = textColor),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(vertical = 15.dp, horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                leftIcon?.let {
                    Icon(
                        painter = painterResource(id = it),
                        contentDescription = "",
                        tint = leftIconColor,
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            color = hintColor,
                        )
                    }
                    innerTextField()
                }
                rightIcon()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun WavveBasicTextFieldPreview() {
    ANDANDROIDTheme {
        WavveBasicTextField(
            value = "",
            onValueChange = {},
            cursorBrush = SolidColor(Color.Blue),
        )
    }
}