package com.example.myshop.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun getShopList(): LiveData<List<ShopItem>>
    suspend fun addItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int): ShopItem
    suspend fun removeItem(shopItem: ShopItem)
    suspend fun editItem(shopItem: ShopItem)
    suspend fun saveEditItem(shopItem: ShopItem)
}