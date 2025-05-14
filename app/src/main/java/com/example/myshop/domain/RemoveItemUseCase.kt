package com.example.myshop.domain

class RemoveItemUseCase (private val shopListRepository: ShopListRepository){

    suspend fun removeItem(shopItem: ShopItem){
        shopListRepository.removeItem(shopItem = shopItem)
    }

}