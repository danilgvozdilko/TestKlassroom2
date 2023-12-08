package com.game.testklassroom2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.game.testklassroom2.databinding.ItemPostBinding
import com.game.testklassroom2.ui.model.PostItemModel


class PostsAdapter(
    private val onPageEndReached: () -> Unit
) : ListAdapter<PostItemModel, PostsAdapter.GifViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)
        if (position == itemCount - 1) {
            onPageEndReached()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
        )
    }

    class GifViewHolder(private var binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val requestManager = Glide.with(itemView.context)

        fun bind(post: PostItemModel) {
            with(binding) {
                userName.text = post.userName
                date.text = post.date
                message.text = post.message
                requestManager.load(post.userPic).into(awaUser)
                requestManager.load(post.photo).into(photo)

            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<PostItemModel>() {

        override fun areItemsTheSame(oldItem: PostItemModel, newItem: PostItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PostItemModel,
            newItem: PostItemModel
        ): Boolean {
            return oldItem == newItem
        }
    }

}