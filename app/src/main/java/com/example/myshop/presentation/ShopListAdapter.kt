package com.example.myshop.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.R
import com.example.myshop.domain.ShopItem
import java.util.zip.Inflater

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var onShopItemLongClick: ((ShopItem) -> Unit)? = null
    var onShopItemClick: ((ShopItem) -> Unit)? = null
    var counter: Int = 1

    var shopList = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(shopList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        if(viewType == 1){
            return ShopItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_shop_enabled, parent, false)
            )
        }
        return ShopItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_shop_disabled, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: "+ counter++)
        val shopItem = shopList[position]
        val status = true///
        shopItem.also {
            holder.tvName.text = it.name
            it.count.toString().also { holder.tvCount.text = it }
        }

        holder.view.setOnLongClickListener {
            onShopItemLongClick?.invoke(shopItem)
            true
        }

        holder.view.setOnClickListener{
            onShopItemClick?.invoke(shopItem)
            true
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun getItemViewType(position: Int): Int {
        val shopItem = shopList[position]
        if(shopItem.enabled){
            return VIEW_TYPE_ENABLED
        }
        return VIEW_TYPE_DISABLED
    }

    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    interface OnShopItemLongClickListener{
        fun onShopItemLongClick(shopItem: ShopItem)
    }

    companion object{
        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = -1

        const val MAX_POOL_SIZE = 15
    }
}