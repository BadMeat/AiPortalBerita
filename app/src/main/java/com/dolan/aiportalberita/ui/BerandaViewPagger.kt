package com.dolan.aiportalberita.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.loadImage
import com.dolan.aiportalberita.model.ArticlesItem

class BerandaViewPagger(private val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    val articleItem = mutableListOf<ArticlesItem>()

    fun setImage(url: List<ArticlesItem>) {
        articleItem.clear()
        articleItem.addAll(url)
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === (`object` as ConstraintLayout)
    }

    override fun getCount() = articleItem.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.beranda_pagger_layout, container, false)
        val img = view.findViewById<ImageView>(R.id.img_beranda)
        val txt = view.findViewById<TextView>(R.id.txt_title)
        loadImage(img, articleItem[position].urlToImage)
        txt.text = articleItem[position].title
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}