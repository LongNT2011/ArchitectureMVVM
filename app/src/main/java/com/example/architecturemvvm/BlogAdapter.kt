package com.example.architecturemvvm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.architecturemvvm.databinding.ItemBlogBinding

class BlogAdapter(
    private val blogViewModel: BlogViewModel
) : Adapter<BlogAdapter.BlogViewHolder>() {

    private lateinit var listBlog: List<Blog>

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listBlog: List<Blog>) {
        this.listBlog = listBlog
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =
            DataBindingUtil.inflate<ItemBlogBinding>(inflater, R.layout.item_blog, parent, false)
        return BlogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBlog.size
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(listBlog[position])
        holder.getBinding().btnDelete.setOnClickListener {
            blogViewModel.removeBLog(position)
        }
    }

    inner class BlogViewHolder(private val binding: ItemBlogBinding) : ViewHolder(binding.root) {
        fun bind(item: Blog) {
            binding.blog = item
        }

        fun getBinding(): ItemBlogBinding {
            return binding
        }
    }
}