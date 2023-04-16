package com.example.architecturemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var blogAdapter: BlogAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var blogViewModel: BlogViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setContentView(binding.root)
    }

    private fun init() {
        blogViewModel = ViewModelProvider(this)[BlogViewModel::class.java]
        blogAdapter = BlogAdapter(blogViewModel)
        val manager = LinearLayoutManager(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.rcvBlog.layoutManager = manager
        binding.rcvBlog.adapter = blogAdapter
        blogViewModel.getlistBlogLive()
            .observe(this) { listBlogLive -> blogAdapter.setData(listBlogLive) }
    }
}