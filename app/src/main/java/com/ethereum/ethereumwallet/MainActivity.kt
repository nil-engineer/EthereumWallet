package com.ethereum.ethereumwallet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ethereum.ethereumwallet.ui.theme.AppTheme
import org.web3j.crypto.Bip32ECKeyPair
import org.web3j.crypto.Bip44WalletUtils
import org.web3j.crypto.Bip44WalletUtils.generateBip44KeyPair
import org.web3j.crypto.Credentials
import org.web3j.crypto.MnemonicUtils

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val generator = WalletGenerator()
        val triple = generator.generateWallet()
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    walletAddressView(generator, triple)
                }
            }
        }
    }

//     fun generateWallet(): Triple<List<String>, String, String> {
//        //initial entropy to create mnemonic words
//        val initialEntropy = ByteArray(16)
//        SecureRandomUtils.secureRandom().nextBytes(initialEntropy)
//        //generate mnemonic words randomly and securely
//        val mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
//        //split mnemonic words to show in ui
//        val separatedMnemonic = mnemonic.split(" ")
//        val seed = MnemonicUtils.generateSeed(mnemonic, "")
//        val masterKeypair = Bip32ECKeyPair.generateKeyPair(seed)
//        val bip44Keypair: Bip32ECKeyPair = generateBip44KeyPair(masterKeypair, false)
//        val hexPrivateKey = bip44Keypair.privateKey.toString(16)
//        val credentials: Credentials = Bip44WalletUtils.loadBip44Credentials("", mnemonic)
//        val addr = credentials.address
//        return Triple(separatedMnemonic, addr, hexPrivateKey)
//    }

}

//@Composable
//fun walletAddressView(generator: WalletGenerator, triple: Triple<List<String>, String, String>/*wordList: List<String>, address: String, privateKey: String*/) {
//
//    Column {
//        Text(
//            text = stringResource(R.string.mnemonic),
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            color = Color.Black,
//            maxLines = 1,
//            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
////                modifier = Modifier.align(Alignment.CenterVertically)
//        )
//        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
//            items(triple.first.size) {item->
//                Column {
//                    Text(text = "item")
//                }
//            }
//        }
//        Text(
//            text = stringResource(R.string.address),
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            color = Color.Black,
//            maxLines = 1,
//            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
////                modifier = Modifier.align(Alignment.CenterVertically)
//        )
//
//        Text(
//            text = triple.second,
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            color = Color.Black,
//            maxLines = 1,
//            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
////                modifier = Modifier.align(Alignment.CenterVertically)
//        )
//        Text(
//            text = stringResource(R.string.private_key),
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            color = Color.Black,
//            maxLines = 1,
//            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
////                modifier = Modifier.align(Alignment.CenterVertically)
//        )
//
//        Text(
//            text = triple.third,
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Start,
//            color = Color.Black,
//            maxLines = 1,
//            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
////                modifier = Modifier.align(Alignment.CenterVertically)
//        )
//    }
//    Row {
//        Button(onClick = {
//            //your onclick code here
//            generator.generateWallet()
//        }) {
//            Text(text = "Re-generate")
//        }
//
//        Button(onClick = {
//            //your onclick code here
//        }) {
//            Text(text = "Sign a message")
//        }
//    }
//}
