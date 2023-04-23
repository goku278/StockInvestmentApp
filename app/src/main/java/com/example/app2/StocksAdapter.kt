package com.example.app2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app2.model.StocksActivity

class StocksAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var mList: List<StocksActivity> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.stocks_list_layout, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount() = mList.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemViewType(position: Int) = position


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bindItems(mList[position], position)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivIcon = itemView.findViewById<ImageView>(R.id.ivIcon1)
        private var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle1)
        private var tvSubTitle = itemView.findViewById<TextView>(R.id.tvSubTitle1)
        private var tvRating = itemView.findViewById<TextView>(R.id.tvRating1)
        private var tvPercentage = itemView.findViewById<TextView>(R.id.tvPercentage1)
        private var tvValuation = itemView.findViewById<TextView>(R.id.tvValuation1)
        private var tvShares = itemView.findViewById<TextView>(R.id.tvShares1)
//        private var tvBottomSubText = itemView.findViewById<TextView>(R.id.tvBottomSubText)

        fun bindItems(details: StocksActivity, position: Int) = with(itemView) {
            Glide.with(context).load(details.icon).into(ivIcon)

            tvTitle.text = details.companyName
            tvSubTitle.text = details.companyName

            tvRating.text = details.bottomNumber

            tvPercentage.text = details.percent
            tvValuation.text = details.valuation

            tvShares.text = details.shares
        }
    }

}