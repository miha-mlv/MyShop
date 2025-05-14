package com.example.myshop.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshop.data.ShopListRepositoryImpl
import com.example.myshop.domain.EditItemUseCase
import com.example.myshop.domain.GetShopListUseCase
import com.example.myshop.domain.RemoveItemUseCase
import com.example.myshop.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application
) : AndroidViewModel(application){

    private val repository = ShopListRepositoryImpl(application =  application)

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeItemUseCase = RemoveItemUseCase(repository)
    private val editItemUseCase = EditItemUseCase(repository)

    private val scope = CoroutineScope(Dispatchers.IO)


    val shopList = getShopListUseCase.getShopList()


    fun removeItem(item: ShopItem){
        scope.launch {
            removeItemUseCase.removeItem(item)
        }

    }

    fun editItem(item: ShopItem){
        scope.launch {
            editItemUseCase.editItem(item.copy(enabled = !item.enabled))
        }

    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}