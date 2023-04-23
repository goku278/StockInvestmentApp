package com.example.app2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app2.model.WatchList

class WatchListAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mList: List<WatchList> = arrayListOf()
    var userType = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.watch_list_layout, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindItems(mList[position], position)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivIcon = itemView.findViewById<ImageView>(R.id.ivIcon)
        private var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private var tvSubTitle = itemView.findViewById<TextView>(R.id.tvSubTitle)
        private var tvRating = itemView.findViewById<TextView>(R.id.tvRating)
        private var tvBottomText = itemView.findViewById<TextView>(R.id.tvBottomText)
        private var tvBottomSubText = itemView.findViewById<TextView>(R.id.tvBottomSubText)

        fun bindItems(details: WatchList, position: Int) = with(itemView) {
            Glide.with(context).load(details.icon).into(ivIcon)

            tvTitle.text = details.companyName
            tvSubTitle.text = details.companyName

            tvRating.text = details.percent

            tvBottomText.text = details.bottomNumber
            tvBottomSubText.text = details.valuation
        }
    }

}