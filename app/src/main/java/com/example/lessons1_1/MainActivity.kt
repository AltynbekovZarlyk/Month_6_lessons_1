package com.example.lessons1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.lessons1_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf(
        "https://klike.net/uploads/posts/2023-04/1682052823_2-6.jpg",
        "https://klike.net/uploads/posts/2023-04/1682052247_3-4.jpg",
        "https://klike.net/uploads/posts/2023-04/1682055634_2-1.jpg",
        "https://klike.net/uploads/posts/2023-04/1682055567_2-4.jpg",
        "https://klike.net/uploads/posts/2022-12/1671691370_2.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnSubmit.setOnClickListener {
            val url = binding.etUrl.text.toString()
            if (Patterns.WEB_URL.matcher(url).matches()) {
                list.add(url)
                binding.etUrl.text.clear()
            } else {
                Toast.makeText(this, "Url is not validate", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRandom.setOnClickListener {
            val item = list.random()
            Glide.with(this).load(item).into(binding.ivPhoto)
        }
    }
}