package com.solo4.cheatcodeapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.solo4.cheatcodeapp.R
import com.solo4.cheatcodeapp.model.cheatsheet.UiCheat

@Composable
fun ConsoleSheetItem(modifier: Modifier, item: UiCheat, onFavoriteClick: () -> Unit = {}, onClick: () -> Unit = {}) {
    Row(modifier = modifier.fillMaxWidth()) {
        Image(
            modifier = Modifier.padding(horizontal = 10.dp).clickable(onClick = onFavoriteClick),
            painter = painterResource(id = if (item.isFavourite) R.drawable.ic_star_filled else R.drawable.ic_star_blank),
            contentDescription = "Is Favourite Cheat"
        )
        Column(modifier = Modifier.weight(1f).clickable(onClick = onClick)) {
            Text(text = item.description)
            Text(text = item.guide.joinToString())
            Row {
                item.guide.forEach { command ->
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = command.imageResId),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}
