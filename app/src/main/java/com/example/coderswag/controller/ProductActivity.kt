package com.example.coderswag.controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.R
import com.example.coderswag.adapter.ProductAdapter
import com.example.coderswag.service.EXTRA_CATEGORY
import com.example.coderswag.service.dataServices
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val cat_type = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this, dataServices.getProducts(cat_type))

        var spancount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spancount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720){
            spancount = 3
        }

        val layoutManager = GridLayoutManager(this, spancount)
        productlistview.layoutManager = layoutManager
        productlistview.adapter = adapter

    }
}