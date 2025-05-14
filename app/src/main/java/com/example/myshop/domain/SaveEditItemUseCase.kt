package com.example.myshop.domain

class SaveEditItemUseCase(private val repository: ShopListRepository) {

    suspend fun saveEditItem(shopItem: ShopItem){
        repository.saveEditItem(shopItem = shopItem)
    }
}