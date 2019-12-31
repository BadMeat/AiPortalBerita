package com.dolan.aiportalberita.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.databinding.BusinessItemBinding
import com.dolan.aiportalberita.model.ArticlesItem

/**
 * Created by Bencoleng on 30/12/2019.
 */
class BusinessAdapter : RecyclerView.Adapter<BusinessAdapter.Holder>() {

    private val listBusiness = mutableListOf<ArticlesItem>()

    fun setListBusiness(list: List<ArticlesItem>) {
        listBusiness.clear()
        listBusiness.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<BusinessItemBinding>(
            layout,
            R.layout.business_item,
            parent,
            false
        )
        return Holder(view)
    }

    override fun getItemCount() = listBusiness.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.news = listBusiness[position]
    }

    class Holder(var view: BusinessItemBinding) : RecyclerView.ViewHolder(view.root)
}