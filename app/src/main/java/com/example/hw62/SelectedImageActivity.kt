package com.example.hw62

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw62.databinding.ActivitySelectedImageBinding

class SelectedImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectedImageBinding
    private var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getIntegerArrayListExtra(MainActivity.KEY)

        if(result != null){
            imageList = result
        }

        val adapter = ImageAdapter(imageList, null, null)

        binding.recyclerView.adapter = adapter
    }
}