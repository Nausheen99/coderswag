package com.example.coderswag.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.R
import com.example.coderswag.model.Category

class CategoryAdapter(context: Context, categories: List<Category>):BaseAdapter() {

    val context = context
    val categories = categories


    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View

        val holder : ViewHolder
        if (convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()

            holder.categoryImage = categoryView.findViewById(R.id.catimage)
            holder.categoryName = categoryView.findViewById(R.id.catname)

            categoryView.tag = holder
        } else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }


        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image,"drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title
        return categoryView

    }

    private class ViewHolder{
        var categoryImage : ImageView? = null
        var categoryName: TextView? = null

    }

}