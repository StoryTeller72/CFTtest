package com.example.cfttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cfttest.databinding.ActivityMainBinding
import com.example.cfttest.retrofit.CardInfoAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cardApi = retrofit.create(CardInfoAPI::class.java)

        binding.testBtn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val card = cardApi.getCardByBIN()
                runOnUiThread {
                    binding.testTextView.text = card.bank.name
                    binding.testEmoji.text = card.country.emoji
                }
            }
        }
    }
}