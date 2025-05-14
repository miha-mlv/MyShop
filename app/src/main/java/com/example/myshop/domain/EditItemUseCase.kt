package com.example.myshop.domain

class EditItemUseCase (private val shopListRepository: ShopListRepository){

    suspend fun editItem(shopItem: ShopItem){
        shopListRepository.editItem(shopItem = shopItem)
    }
}