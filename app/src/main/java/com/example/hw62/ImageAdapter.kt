package com.example.hw62

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw62.databinding.ItemImageBinding
import java.nio.file.Files.delete
import java.nio.file.Files.size


class ImageAdapter(
    private val images: ArrayList<Int>,
    private val onClick: ((url: Int) -> Unit)?,
    private val delete: ((url: Int) -> Unit)?
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int = images.size

    inner class ImageViewHolder(private val binding:ItemImageBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(url: Int){

            binding.ivImage.setImageResource(url)

            itemView.setOnClickListener {
                with(binding) {
                    if (viewDark.visibility == View.GONE) {
                        onClick?.let { it1 -> it1(url) }
                        viewDark.visibility = View.VISIBLE
                    } else {
                        delete?.let { it1 -> it1(url) }
                        viewDark.visibility = View.GONE
                    }
                }
            }
        }
    }
}