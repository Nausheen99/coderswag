package com.example.coderswag.service

import com.example.coderswag.model.Category
import com.example.coderswag.model.Product

object dataServices {
    val categories = listOf(
        Category("SHIRTS", "shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS", "hatimage"),
        Category("DIGITAL GOODS", "digitalgoodsimage")
    )

    val shirts = listOf(
        Product("one", "750pkr", "shirt1"),
        Product("two","750pkr","shirt2"),
        Product("three","950pkr", "shirt3"),
        Product("four","950pkr", "shirt4")
    )

    val hoodies = listOf(
        Product("one", "1250pkr", "hoodie1"),
        Product("two","1250pkr","hoodie2"),
        Product("three","1550pkr", "hoodie3"),
        Product("four","1550pkr", "hoodie4")
    )

    val hats = listOf(
        Product("one", "550pkr", "hat1"),
        Product("two","550pkr","hat2"),
        Product("three","750pkr", "hat3"),
        Product("four","750pkr", "hat4")
    )

    val digitalGoods = listOf<Product>()
    fun getProducts(category: String?) : List<Product>{

        return when(category) {
            "SHIRTS" -> shirts
            "HATS" -> hats
            "HOODIES" -> hoodies
            else -> digitalGoods
        }
    }
}