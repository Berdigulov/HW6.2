package com.example.hw62

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.indexOf
import com.example.hw62.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listImage = arrayListOf<Int>()
    private var selectedImage = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillList()

        val adapter = ImageAdapter(listImage, this::onClick, this::delete)

        binding.recyclerView.adapter = adapter
        initClicker()
    }

    private fun fillList(){
        listImage.add(R.drawable.ic_glassed_ball)
        listImage.add(R.drawable.ic_eiffel_tower)
        listImage.add(R.drawable.ic_tree)
        listImage.add(R.drawable.ic_glassed_ball)
        listImage.add(R.drawable.ic_eiffel_tower)
        listImage.add(R.drawable.ic_tree)
        listImage.add(R.drawable.ic_glassed_ball)
        listImage.add(R.drawable.ic_eiffel_tower)
        listImage.add(R.drawable.ic_tree)
        listImage.add(R.drawable.ic_glassed_ball)
        listImage.add(R.drawable.ic_eiffel_tower)
        listImage.add(R.drawable.ic_tree)
    }

    private fun onClick(url: Int) {
        selectedImage.add(listImage[listImage.indexOf(url)])
    }

    private fun delete(url: Int){
        selectedImage.remove(listImage[listImage.indexOf(url)])
    }

    private fun initClicker(){
        binding.btnPick.setOnClickListener {
            Intent(this, SelectedImageActivity::class.java).apply {
                putIntegerArrayListExtra(KEY,selectedImage)
                startActivity(this)
            }
        }
    }

    companion object{
        const val KEY = "key"
    }
}
