package com.example.taskplanner.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taskplanner.R
import com.example.taskplanner.data.Tasks
import com.example.taskplanner.ui.AppViewModelProvider
import kotlinx.coroutines.launch


@Composable
fun TaskItem(task: Tasks, viewModel: HomeScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)) {

    var isChecked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Card(modifier = Modifier.padding(8.dp).height(60.dp).fillMaxWidth(),
        colors = CardColors(containerColor = Color.White, contentColor = Color.Black, disabledContainerColor = Color.White, disabledContentColor = Color.Black)
    ){
            Row(horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(2.dp)){

                    Checkbox(checked = isChecked, onCheckedChange = { isChecked = !isChecked })

                if(isChecked){
                    Text(task.taskName,
                        modifier = Modifier.padding(start = 2.dp).align(Alignment.CenterVertically).weight(1f)
                        , style = MaterialTheme.typography.bodyLarge,
                        textDecoration = TextDecoration.LineThrough, color = Color.Red)
                }else{
                    Text(task.taskName, modifier = Modifier.padding(start = 2.dp)
                        .align(Alignment.CenterVertically).weight(1f)
                        , style = MaterialTheme.typography.bodyLarge)
                }

                IconButton(onClick = { coroutineScope.launch {
                    viewModel.deleteTasks(task)
                }
                }, modifier = Modifier.align(Alignment.CenterVertically)){
                    Icon(painter = painterResource(id = R.drawable.delete_24), contentDescription = "Delete")
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    TaskItem(Tasks(1,"Develop Project"))
}