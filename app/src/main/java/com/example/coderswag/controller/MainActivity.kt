package com.example.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapter.CategoryAdapter
import com.example.coderswag.adapter.CategoryAdapterRecycler
import com.example.coderswag.model.Category
import com.example.coderswag.service.EXTRA_CATEGORY
import com.example.coderswag.service.dataServices
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapterRecycler(this, dataServices.categories){
            category -> val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categorylistview.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categorylistview.layoutManager = layoutManager
        categorylistview.setHasFixedSize(true)


    }


}
