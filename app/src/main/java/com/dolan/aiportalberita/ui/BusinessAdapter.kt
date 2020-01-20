package com.dolan.aiportalberita.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.databinding.BusinessItemBinding
import com.dolan.aiportalberita.model.ArticlesItem

/**
 * Created by Bencoleng on 30/12/2019.
 */
class BusinessAdapter(private val listener: (ArticlesItem) -> Unit) :
    RecyclerView.Adapter<BusinessAdapter.Holder>(), Filterable,
    NewsDetailListener {

    private val listBusiness = mutableListOf<ArticlesItem>()
    private var listNewsFilter = listBusiness

    fun setListBusiness(list: List<ArticlesItem>) {
        listBusiness.clear()
        listBusiness.addAll(list)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val input = p0.toString()
                listNewsFilter = if (input.isEmpty()) {
                    listBusiness
                } else {
                    val result = mutableListOf<ArticlesItem>()
                    for (data: ArticlesItem in listBusiness) {
                        data.title?.let {
                            if (it.contains(input, true)) {
                                result.add(data)
                            }
                        }
                    }
                    result
                }
                val resultFilter = FilterResults()
                resultFilter.values = listNewsFilter
                return resultFilter
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                p1?.let {
                    listNewsFilter = it.values as MutableList<ArticlesItem>
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val layout = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<BusinessItemBinding>(
            layout,
            R.layout.business_item,
            parent,
            false
        )
        return Holder(view, listener)
    }

    override fun getItemCount() = listNewsFilter.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.news = listNewsFilter[position]
        holder.onClick()
        holder.view.listener = this
    }

    override fun onClick(view: View) {
//        val action = BerandaFragmentDirections.actionToDetail(view.news)
//        Navigation.findNavController(view).navigate(action)
    }

    class Holder(var view: BusinessItemBinding, val listener: (ArticlesItem) -> Unit) :
        RecyclerView.ViewHolder(view.root) {

        fun onClick() {
            itemView.setOnClickListener {
                view.news?.let {
                    listener(it)
                }
            }
        }
    }
}