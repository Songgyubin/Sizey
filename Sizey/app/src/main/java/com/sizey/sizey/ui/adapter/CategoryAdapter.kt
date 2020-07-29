package com.sizey.sizey.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sizey.sizey.R
import com.sizey.sizey.data.model.Category

class CategoryAdapter(
    val context: Context,
    private val items: ArrayList<Category>
)
    : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class CategoryViewHolder(parent:ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
    ){


    }
}