package com.isayevapps.photogallery.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.isayevapps.photogallery.R
import com.isayevapps.photogallery.api.GalleryItem
import com.isayevapps.photogallery.databinding.ListItemGalleryBinding

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>
) : RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(
        private val binding: ListItemGalleryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(galleryItem: GalleryItem) {
            binding.itemImageView.load(galleryItem.url) {
                placeholder(R.drawable.empty_img)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun getItemCount() = galleryItems.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val galleryItem = galleryItems[position]
        holder.bind(galleryItem)
    }
}