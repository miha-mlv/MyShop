package com.example.myshop.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshop.data.ShopListRepositoryImpl
import com.example.myshop.domain.EditItemUseCase
import com.example.myshop.domain.GetShopListUseCase
import com.example.myshop.domain.RemoveItemUseCase
import com.example.myshop.domain.ShopItem

class MainViewModel : ViewModel(){

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeItemUseCase = RemoveItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun removeItem(item: ShopItem){
        removeItemUseCase.removeItem(item)
    }

    fun editItem(item: ShopItem){
        editItemUseCase.editItem(item.copy(enabled = !item.enabled))
    }


}