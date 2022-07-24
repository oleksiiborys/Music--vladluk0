package com.example.music.ui.common.top_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SimpleAppBar(
    navController: NavController,
    title: String = ""
) {
    Row(
        modifier = Modifier.background(Color.Black)
    ) {
        Icon(
            painter = painterResource(id = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
                .padding(start = 10.dp/*MaterialTheme.padding.start*/)
        )

        Text(
            text = title,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}