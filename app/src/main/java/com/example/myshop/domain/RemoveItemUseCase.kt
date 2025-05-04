package com.example.myshop.domain

class RemoveItemUseCase (private val shopListRepository: ShopListRepository){

    fun removeItem(shopItem: ShopItem){
        shopListRepository.removeItem(shopItem = shopItem)
    }

}