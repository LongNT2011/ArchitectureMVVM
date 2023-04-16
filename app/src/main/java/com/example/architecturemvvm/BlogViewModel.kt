package com.example.architecturemvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlogViewModel : ViewModel() {
    private val listBlogLive: MutableLiveData<ArrayList<Blog>> = MutableLiveData()

    init {
        initData()
    }

    private fun initData() {
        val listBLog = ArrayList<Blog>()
        for (i in 1..10) {
            listBLog.add(Blog("Blog $i"))
        }
        listBlogLive.value = listBLog
    }

    fun getlistBlogLive(): MutableLiveData<ArrayList<Blog>> {
        return listBlogLive
    }

    fun removeBLog(index: Int) {
        val list = listBlogLive.value
        list?.removeAt(index)
        listBlogLive.value = list
    }
}