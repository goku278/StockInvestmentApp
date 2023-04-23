package com.example.app2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MarketHorizontalAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mList: List<Int> = arrayListOf()
    var userType = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_second_list, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindItems(mList[position], position)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivIcon = itemView.findViewById<ImageView>(R.id.ivFirstImage2)

        fun bindItems(details: Int, position: Int) = with(itemView) {
            Glide.with(context).load(details).into(ivIcon)
        }
    }

}