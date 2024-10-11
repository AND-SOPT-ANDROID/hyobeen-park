package org.sopt.and.core.designsystem.component.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.sopt.and.R

@Composable
fun PasswordTextField(
    password: MutableState<String>,
    placeholder: String,
    isVisible: MutableState<Boolean>,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = password.value,
        onValueChange = { newValue ->
            password.value = newValue
            onValueChange(newValue)
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray,
            )
        },
        maxLines = 1,
        shape = RoundedCornerShape(5.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.DarkGray,
            unfocusedContainerColor = Color.DarkGray,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            errorBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
        ),
        visualTransformation = if (isVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            Text(
                text = stringResource(
                    if (isVisible.value) R.string.password_textfield_hide
                    else R.string.password_textfield_show
                ),
                modifier = Modifier
                    .clickable {
                        isVisible.value = !isVisible.value
                    }
                    .padding(end = 10.dp),
                color = Color.White,
            )
        }
    )
}