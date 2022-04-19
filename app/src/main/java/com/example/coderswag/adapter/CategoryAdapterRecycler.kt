package com.example.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.R
import com.example.coderswag.databinding.ActivityMainBinding.bind
import com.example.coderswag.model.Category
import com.example.coderswag.service.dataServices.categories

class CategoryAdapterRecycler (val context: Context,val categories: List<Category>,val itemClick: (Category) -> Unit) :  RecyclerView.Adapter<CategoryAdapterRecycler.Holder>() {

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView){
        val categoryImage = itemView.findViewById<ImageView>(R.id.catimage)
        val categoryName = itemView.findViewById<TextView>(R.id.catname)

        fun bindCategory(category:Category, context: Context ){
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

            itemView.setOnClickListener{itemClick(category)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}