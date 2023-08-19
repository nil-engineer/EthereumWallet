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
 * @param generator: instance of WalletGenerator class passed to re-generate wallet
 * @param triple: a triple object to access generated wallet specifications.
 *                  first item is a list of mnemonic words
 *                  second item is wallet address
 *                  third item is private key
 */

@Composable
fun walletAddressView(generator: WalletGenerator, triple: Triple<List<String>, String, String>/*wordList: List<String>, address: String, privateKey: String*/) {
//    val generator = WalletGenerator()

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
            items(triple.first.size) {
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
            text = triple.second,
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
            text = triple.third,
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
            generator.generateWallet()
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