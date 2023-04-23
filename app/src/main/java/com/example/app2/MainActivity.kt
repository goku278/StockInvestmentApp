package com.example.app2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.app2.model.BannerModel
import com.example.app2.model.StocksActivity
import com.example.app2.model.WatchList
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var vpHome: ViewPager
    private lateinit var toolBar: Toolbar
    private lateinit var title: TextView

    private lateinit var adapter: WatchListAdapter
    private lateinit var stockAdapter: StocksAdapter

    private lateinit var rvWatchList: RecyclerView
    private lateinit var rvStocksActivity: RecyclerView

    private lateinit var bottomNav: BottomNavigationView

    private lateinit var tvWatchList: TextView
    private lateinit var tvSeeAll: TextView

    var size = 0

    @SuppressLint("NewApi", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolBar = findViewById(R.id.tbToolbar)

        title = findViewById<TextView>(R.id.tvTitle)

        adapter = WatchListAdapter(this)

        stockAdapter = StocksAdapter(this)

        rvWatchList = findViewById(R.id.rvWatchList)
        rvStocksActivity = findViewById(R.id.rvStocksActivity)

        title.text = "Alex Julia"

        tvWatchList = findViewById(R.id.tvWatchList)

        tvSeeAll = findViewById(R.id.tvSeeAll)

        setClicks()

        vpHome = findViewById(R.id.vpHome)

        setBannerList()

        setWatchList()

        setStocks()

    }

    private fun setClicks() {
        tvWatchList.setOnClickListener {
            val intent = Intent(this, Market::class.java)
            startActivity(intent)
        }

        tvSeeAll.setOnClickListener {
            val intent = Intent(this, StockDetails::class.java)
            startActivity(intent)
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

    private fun setWatchList() {
        var list = arrayListOf<WatchList>()
        var watchList = WatchList()

        watchList.icon = R.drawable.adobe

        watchList.companyName = "Adobe"
        watchList.percent = "5,49%"
        watchList.bottomNumber = "33.49"
        watchList.valuation = "$643.58"

        list.add(watchList)

        watchList = WatchList()

        watchList.icon = R.drawable.tesla

        watchList.companyName = "Tesla"
        watchList.percent = "10,49%"
        watchList.bottomNumber = "80.7"
        watchList.valuation = "$10000.50"

        list.add(watchList)

        watchList = WatchList()

        watchList.icon = R.drawable.nvidia

        watchList.companyName = "Nvidia"
        watchList.percent = "7,49%"
        watchList.bottomNumber = "85.7"
        watchList.valuation = "$5000.50"

        list.add(watchList)

        watchList = WatchList()

        watchList.icon = R.drawable.bitcoin

        watchList.companyName = "Bitcoin"
        watchList.percent = "5,49%"
        watchList.bottomNumber = "91.7"
        watchList.valuation = "$12000.50"

        list.add(watchList)

        watchList = WatchList()

        watchList.icon = R.drawable.dogecoin

        watchList.companyName = "Doge coin"
        watchList.percent = "8,49%"
        watchList.bottomNumber = "92.7"
        watchList.valuation = "$11000.50"

        list.add(watchList)

        runOnUiThread {
            rvWatchList.layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            rvWatchList.adapter = adapter
            adapter.mList = list
            adapter.notifyDataSetChanged()
        }
    }

    private fun setBannerList() {
        var bannerList = mutableListOf<Int>()
        var banner = BannerModel()

        banner.image = R.drawable.stock_img_1
        bannerList.add(R.drawable.stock_img_1)

        banner.image = R.drawable.stock_img_2
        bannerList.add(R.drawable.stock_img_2)

        banner.image = R.drawable.stock_img_3
        bannerList.add(R.drawable.stock_img_3)

        banner.image = R.drawable.stock_img_4
        bannerList.add(R.drawable.stock_img_4)

        banner.image = R.drawable.stock_img_5
        bannerList.add(R.drawable.stock_img_5)

        banner.image = R.drawable.stock_img_6
        bannerList.add(R.drawable.stock_img_6)

        banner.image = R.drawable.stock_img_7
        bannerList.add(R.drawable.stock_img_7)

        println("banner list are -----> $bannerList")

        setBanners(bannerList)
    }

    private fun setBanners(banners: MutableList<Int>) {

        size = banners.size
        val mCustomPagerAdapter = BannerAdapter(this, banners) {}
        vpHome!!.adapter = mCustomPagerAdapter
        vpHome.offscreenPageLimit = size
        vpHome?.adapter?.notifyDataSetChanged()
    }

    private fun setUI() {
        val xValue = ArrayList<String>()
        xValue.add("Sun")
        xValue.add("Mon")
        xValue.add("Tue")
        xValue.add("Wed")
        xValue.add("Thu")
        xValue.add("Fri")
        xValue.add("Sat")

        val lineEntry = ArrayList<Entry>()
        lineEntry.add(Entry(10f, 1))
        lineEntry.add(Entry(70f, 2))
        lineEntry.add(Entry(5f, 3))
        lineEntry.add(Entry(200f, 4))
        lineEntry.add(Entry(30f, 5))
        lineEntry.add(Entry(35f, 6))
        lineEntry.add(Entry(505f, 7))

        val lineDataSet = LineDataSet(lineEntry, "")
        lineDataSet.color = resources.getColor(R.color.green)
        lineDataSet.setDrawValues(false)

        val data = LineData(xValue, lineDataSet)

        val lineChart = findViewById<LineChart>(R.id.lineChart)

        lineChart.data = data
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false);

        lineChart.axisRight.isEnabled = false
        lineChart.axisLeft.isEnabled = false

        lineChart.xAxis.isEnabled = false

        lineChart.setDrawBorders(false);
        lineChart.setDrawGridBackground(false);

        lineDataSet.setDrawFilled(true);

        lineDataSet.setDrawValues(true)


        lineDataSet.setCircleColor(R.color.green);
        lineDataSet.setColor(R.color.green);

        lineChart.animateXY(10000, 10000)
    }

}