package com.example.taskplanner.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThemeChange(showBottomSheet: Boolean = false) {

        ModalBottomSheet(onDismissRequest = {!showBottomSheet}) {
            Text("Pick a theme", style = MaterialTheme.typography.bodyLarge, modifier =  Modifier.padding(8.dp))

            Column {

            }
    }
}