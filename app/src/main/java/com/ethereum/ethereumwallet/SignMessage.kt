package com.ethereum.ethereumwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ethereum.ethereumwallet.databinding.ActivityMainBinding
import com.ethereum.ethereumwallet.databinding.ActivitySignMessageBinding
import org.web3j.crypto.Sign
import org.web3j.utils.Numeric

class SignMessage : AppCompatActivity() {
    private lateinit var binding: ActivitySignMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun signMsg(){
        val str = "amount :812891050357868 input1 :1540802687953004853 input2 :671473924797294281991422" +
                "output1 :1539989796902646985 output2 :671473925610185332349290"
        val messageBytes: ByteArray = str.toByteArray()
        val signature = Sign.signMessage(messageBytes, credentials.ecKeyPair)
        val r = Numeric.toHexString(signature.r)
        val s = Numeric.toHexString(signature.s)
        val v = Numeric.toHexString(signature.v)
        Log.d("sign", "Signature: r=" + r + " s=" + s + " v=" + v)
    }
}