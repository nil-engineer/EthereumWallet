package com.ethereum.ethereumwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ethereum.ethereumwallet.databinding.ActivityMainBinding
import com.ethereum.ethereumwallet.databinding.ActivitySignMessageBinding
import org.web3j.crypto.ECKeyPair
import org.web3j.crypto.Sign
import org.web3j.utils.Numeric
import java.math.BigInteger

class SignMessage : AppCompatActivity() {
    private lateinit var binding: ActivitySignMessageBinding
    private lateinit var ecKeyPair: ECKeyPair
    val message = "amount :812891050357868\n input1 :1540802687953004853\n input2 :671473924797294281991422\n output1 :1539989796902646985\n output2 :671473925610185332349290\n"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //get public key and private key from previous page to use in message signing.
        val b = intent.extras
        val privateKey = b!!.getSerializable(Constants.PRIVATE_KEY) as BigInteger?
        val publicKey = b!!.getSerializable(Constants.PUBLIC_KEY) as BigInteger?
        ecKeyPair = ECKeyPair(privateKey, publicKey)
        fillUi()
        binding.sign.setOnClickListener{
            signMsg()
        }
    }

    private fun fillUi(){
        binding.message.text = message
        binding.nonce.text = "37"
        binding.privateKey.text = ecKeyPair.privateKey.toString(16)
//        binding.hash.text = ecKeyPair.hashCode().toString()
    }

    // sign message using private key and public key
    private fun signMsg(){
        val messageBytes: ByteArray = message.toByteArray()
        val signature = Sign.signMessage(messageBytes, ecKeyPair)
        val r = Numeric.toHexString(signature.r)
        val s = Numeric.toHexString(signature.s)
        val v = Numeric.toHexString(signature.v)
        Log.d("sign", "Signature: r=" + r + " s=" + s + " v=" + v)
        binding.signRsv.text = "Signature: r=$r s=$s v=$v"
    }
}