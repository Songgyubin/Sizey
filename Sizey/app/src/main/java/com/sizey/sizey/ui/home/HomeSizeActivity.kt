package com.sizey.sizey.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sizey.sizey.R
import com.sizey.sizey.data.model.Category
import com.sizey.sizey.ui.adapter.CategoryAdapter
import com.sizey.sizey.ui.setting.SettingActivity
import kotlinx.android.synthetic.main.activity_home_size.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class HomeSizeActivity : AppCompatActivity() {

    private lateinit var adapter: CategoryAdapter
    private lateinit var items: ArrayList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_size)
        recycler_category.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        items = ArrayList()
        items.add(Category(R.drawable.tmpimg, "아우터"))
        items.add(Category(R.drawable.tmpimg, "상의"))
        items.add(Category(R.drawable.tmpimg, "바지"))
        items.add(Category(R.drawable.tmpimg, "치마"))
        items.add(Category(R.drawable.tmpimg, "원피스"))
        items.add(Category(R.drawable.tmpimg, "원피스"))
        items.add(Category(R.drawable.tmpimg, "원피스"))
        adapter = CategoryAdapter(this, items)
        recycler_category.adapter = adapter
        adapter.setOnItemClickListener(object : CategoryAdapter.OnCategoryListener{
            override fun onItemClick(v: View, position: Int) {
                toast(adapter.getItem(position).name)
                startActivity<SettingActivity>()
            }
        })

    }

    private fun addAR(){

    }


}