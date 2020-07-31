package com.sizey.sizey.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sizey.sizey.R
import com.sizey.sizey.data.model.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    val context: Context,
    private val items: ArrayList<Category>
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var mListener: OnCategoryListener? = null

    fun setOnItemClickListener(listener: OnCategoryListener){
        this.mListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(parent)


    override fun getItemCount(): Int = items.size

    fun getItem(position: Int):Category{
        return items[position]
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        items[position].let { item ->
            with(holder) {
                ivCategoryImg.setImageResource(item.img)
                tvCategoryName.text = item.name
                ivCategoryImg.setOnClickListener {
                        val pos = position
                    if (pos!=RecyclerView.NO_POSITION){
                        mListener?.onItemClick(it,pos)
                    }
                }
            }
        }
    }

    interface OnCategoryListener {
        fun onItemClick(v: View, position: Int)
    }

    inner class CategoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
    ) {
        val ivCategoryImg: ImageView = itemView.iv_category_img
        val tvCategoryName: TextView = itemView.tv_category_name

    }
}