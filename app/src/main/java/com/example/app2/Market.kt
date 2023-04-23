package com.example.app2

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app2.model.StocksActivity
import kotlinx.android.synthetic.main.activity_main.*

class Market : AppCompatActivity() {
    private lateinit var ivMenu: ImageView
    private lateinit var ivSearch: ImageView
    private lateinit var tvSubTitle: TextView

    private lateinit var rvStockImage: RecyclerView

    private lateinit var adapter: MarketHorizontalAdapter

    private lateinit var rvStocksActivity: RecyclerView

    private lateinit var stockAdapter: StocksAdapter

    private var size: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_market)

        adapter = MarketHorizontalAdapter(this)

        stockAdapter = StocksAdapter(this)

        rvStockImage = findViewById(R.id.rvStockImage)

        rvStocksActivity = findViewById(R.id.rvStocksActivity)


        ivMenu = findViewById(R.id.ivMenu)
        ivSearch = findViewById(R.id.ivSearch)
        tvSubTitle = findViewById(R.id.tvSubTitle)
        setUI()

        setBannerList()

        setStocks()

        setClicks()
    }

    private fun setClicks() {
        ivMenu.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.S) {
            // Android 12 or Android 12 Beta
            bottom_navigation.itemBackground = getDrawable(R.drawable.bottom_navigation_back)
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    println("clicked on bottom navigation")
                    val intent = Intent(this, Market::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_piechart -> {
                    println("clicked on bottom navigation")
                    val intent = Intent(this, Market::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_synchronize -> {
                    println("clicked on bottom navigation")
                    val intent = Intent(this, Market::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_filter -> {
                    println("clicked on bottom navigation")
                    val intent = Intent(this, StockDetails::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_user -> {
                    println("clicked on bottom navigation")
                    val intent = Intent(this, StockDetails::class.java)
                    startActivity(intent)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun setStocks() {
        var list = arrayListOf<StocksActivity>()
        var stocks = StocksActivity()

        stocks.icon = R.drawable.nvidia
        stocks.companyName = "Nvidia"
        stocks.percent = "7,49%"
        stocks.bottomNumber = "85.7"
        stocks.valuation = "$5000.50"
        stocks.shares = "50 shares"

        list.add(stocks)

        stocks = StocksActivity()

        stocks.icon = R.drawable.adobe
        stocks.companyName = "Adobe"
        stocks.percent = "5,49%"
        stocks.bottomNumber = "33.49"
        stocks.valuation = "$643.58"
        stocks.shares = "10 shares"

        list.add(stocks)

        stocks = StocksActivity()

        stocks.icon = R.drawable.tesla
        stocks.companyName = "Tesla"
        stocks.percent = "10,49%"
        stocks.bottomNumber = "80.7"
        stocks.valuation = "$10000.50"
        stocks.shares = "20 shares"


        list.add(stocks)

        stocks = StocksActivity()

        stocks.icon = R.drawable.bitcoin
        stocks.companyName = "Bitcoin"
        stocks.percent = "5,49%"
        stocks.bottomNumber = "91.7"
        stocks.valuation = "$12000.50"
        stocks.shares = "30 shares"


        list.add(stocks)

        stocks = StocksActivity()

        stocks.icon = R.drawable.dogecoin
        stocks.companyName = "Doge coin"
        stocks.percent = "8,49%"
        stocks.bottomNumber = "92.7"
        stocks.valuation = "$11000.50"
        stocks.shares = "100 shares"


        list.add(stocks)

        runOnUiThread {
            rvStocksActivity.layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
            rvStocksActivity.adapter = stockAdapter
            stockAdapter.mList = list
            stockAdapter.notifyDataSetChanged()
        }

    }


    private fun setBannerList() {
        var bannerList = mutableListOf<Int>()

        bannerList.add(R.drawable.stock_img_1)

        bannerList.add(R.drawable.stock_img_2)

        bannerList.add(R.drawable.stock_img_3)

        bannerList.add(R.drawable.stock_img_4)

        bannerList.add(R.drawable.stock_img_5)

        bannerList.add(R.drawable.stock_img_6)

        bannerList.add(R.drawable.stock_img_7)

        println("banner list are -----> $bannerList")

        setBanners(bannerList)
    }

    private fun setBanners(banners: MutableList<Int>) {

        runOnUiThread {
            rvStockImage.layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvStockImage.adapter = adapter
            adapter.mList = banners
            adapter.notifyDataSetChanged()
        }

    }


    private fun setUI() {
        ivMenu.setImageResource(R.drawable.left)
        ivSearch.visibility = View.GONE
        tvSubTitle.text = "Markets"
    }
}