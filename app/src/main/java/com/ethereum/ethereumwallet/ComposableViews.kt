package com.ethereum.ethereumwallet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** composable view that show wallet specifications.
 * @param wordList: list of mnemonic words to show
 * @param address: Ethereum wallet address to show
 * @param privateKey: wallet private key to show
 */

@Composable
fun walletAddressView(wordList: List<String>, address: String, privateKey: String) {
    Column {
        Text(
            text = stringResource(R.string.mnemonic),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
//                modifier = Modifier.align(Alignment.CenterVertically)
        )
        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            item(wordList) {
//                LazyColumn {
                    Text(text = "test")
//                }
            }
        }
        Text(
            text = stringResource(R.string.address),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
//                modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = address,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
//                modifier = Modifier.align(Alignment.CenterVertically)
        )
        Text(
            text = stringResource(R.string.private_key),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
//                modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = privateKey,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            color = Color.Black,
            maxLines = 1,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
//                modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
    Row {
        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "Re-generate")
        }

        Button(onClick = {
            //your onclick code here
        }) {
            Text(text = "Sign a message")
        }
    }
}