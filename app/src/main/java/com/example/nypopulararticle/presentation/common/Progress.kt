package com.example.nypopulararticle.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.nypopulararticle.presentation.ui.theme.Purple40

/*
Created by 
Islam Ibrahim
islam.mahmoud116@gmail.com
*/
@Composable
fun Progress(value: Boolean = true) {
    val showDialog = remember { mutableStateOf(value) }
    if (showDialog.value) {
        Dialog(
            onDismissRequest = { showDialog.value = false },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
            ) {
                CircularProgressIndicator(
                    color = Purple40
                )
            }
        }
    }
}
