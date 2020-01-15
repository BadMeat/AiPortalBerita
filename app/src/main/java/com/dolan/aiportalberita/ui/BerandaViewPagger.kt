package com.dolan.aiportalberita.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.loadImage
import com.dolan.aiportalberita.model.ArticlesItem

class BerandaViewPagger(private val context: Context) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    val imageUrl = mutableListOf<ArticlesItem>()

    fun setImage(url: List<ArticlesItem>) {
        imageUrl.clear()
        imageUrl.addAll(url)
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === (`object` as ConstraintLayout)
    }

    override fun getCount() = imageUrl.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.beranda_pagger_layout, container, false)
        val img = view.findViewById<ImageView>(R.id.img_beranda)
        loadImage(img, imageUrl[position].urlToImage)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}