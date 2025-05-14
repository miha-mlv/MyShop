package com.example.myshop.domain

class AddItemUseCase (private val shopListRepository: ShopListRepository){

    suspend fun addItem(shopItem: ShopItem){
        shopListRepository.addItem(shopItem = shopItem)
    }

}