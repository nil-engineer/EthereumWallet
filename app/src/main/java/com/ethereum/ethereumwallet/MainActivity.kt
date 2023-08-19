package com.ethereum.ethereumwallet

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ethereum.ethereumwallet.databinding.ActivityMainBinding
import org.web3j.crypto.Bip32ECKeyPair
import org.web3j.crypto.Bip44WalletUtils
import org.web3j.crypto.Bip44WalletUtils.generateBip44KeyPair
import org.web3j.crypto.Credentials
import org.web3j.crypto.MnemonicUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val walletSpec = generateWallet()
        fillUi(walletSpec)
        binding.regenerate.setOnClickListener(this)
        binding.signMsg.setOnClickListener(this)
    }
    //fill ui with the calculated parameters
    fun fillUi(walletSpec: Triple<String, String, String>) {
        binding.mnemonicWord.text = walletSpec.first
        binding.address.text = walletSpec.second
        binding.privateKey.text = walletSpec.third
    }

    //generate Ethereum wallet address using mnemonic words
    fun generateWallet(): Triple<String, String, String> {
        //initial entropy to create mnemonic words
        val initialEntropy = ByteArray(16)
        SecureRandomUtils.secureRandom().nextBytes(initialEntropy)
        //generate mnemonic words randomly and securely
        val mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
        //split mnemonic words to show in ui
//        val separatedMnemonic = mnemonic.split(" ")
        val seed = MnemonicUtils.generateSeed(mnemonic, "")
        val masterKeypair = Bip32ECKeyPair.generateKeyPair(seed)
        val bip44Keypair: Bip32ECKeyPair = generateBip44KeyPair(masterKeypair, false)
        val hexPrivateKey = bip44Keypair.privateKey.toString(16)
        val credentials: Credentials = Bip44WalletUtils.loadBip44Credentials("", mnemonic)
        val addr = credentials.address
        return Triple(mnemonic, addr, hexPrivateKey)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.regenerate) {
            val walletSpec = generateWallet()
            fillUi(walletSpec)

        } else if (v?.id == R.id.sign_msg) {

        }
    }

}

