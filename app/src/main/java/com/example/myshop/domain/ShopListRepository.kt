package com.example.myshop.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopList(): LiveData<List<ShopItem>>
    fun addItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem
    fun removeItem(shopItem: ShopItem)
    fun editItem(shopItem: ShopItem)
    fun saveEditItem(shopItem: ShopItem)
}