package com.ethereum.ethereumwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ethereum.ethereumwallet.databinding.ActivityMainBinding
import com.ethereum.ethereumwallet.databinding.ActivitySignMessageBinding

class SignMessage : AppCompatActivity() {
    private lateinit var binding: ActivitySignMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignMessageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}