package com.example.trivialapp_base.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun DifficultyDialog(show: Boolean, onDismiss: () -> Unit){
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    ){
        Column (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 20.dp)
        ) {
            Text("Set Easy difficulty")
            Text("Set Midl difficulty")
            Text("Set Hard difficulty")
        }
    }

}
