package com.example.myshop.domain

class AddItemUseCase (private val shopListRepository: ShopListRepository){

    fun addItem(shopItem: ShopItem){
        shopListRepository.addItem(shopItem = shopItem)
    }

}