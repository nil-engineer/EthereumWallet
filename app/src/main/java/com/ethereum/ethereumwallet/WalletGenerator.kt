package com.ethereum.ethereumwallet

import org.web3j.crypto.Bip32ECKeyPair
import org.web3j.crypto.Bip44WalletUtils
import org.web3j.crypto.Credentials
import org.web3j.crypto.MnemonicUtils

class WalletGenerator {

    fun generateWallet(): Triple<List<String>, String, String> {
        //initial entropy to create mnemonic words
        val initialEntropy = ByteArray(16)
        SecureRandomUtils.secureRandom().nextBytes(initialEntropy)
        //generate mnemonic words randomly and securely
        val mnemonic = MnemonicUtils.generateMnemonic(initialEntropy)
        //split mnemonic words to show in ui
        val separatedMnemonic = mnemonic.split(" ")
        val seed = MnemonicUtils.generateSeed(mnemonic, "")
        val masterKeypair = Bip32ECKeyPair.generateKeyPair(seed)
        val bip44Keypair: Bip32ECKeyPair =
            Bip44WalletUtils.generateBip44KeyPair(masterKeypair, false)
        val hexPrivateKey = bip44Keypair.privateKey.toString(16)
        val credentials: Credentials = Bip44WalletUtils.loadBip44Credentials("", mnemonic)
        val addr = credentials.address
        return Triple(separatedMnemonic, addr, hexPrivateKey)
    }
}