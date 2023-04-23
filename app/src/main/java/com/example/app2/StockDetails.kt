package com.example.app2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class StockDetails : AppCompatActivity() {

    private lateinit var ivMenu: ImageView
    private lateinit var ivSearch: ImageView
    private lateinit var tvSubTitle: TextView
    private lateinit var ivBell: ImageView

    private lateinit var llOne: LinearLayout
    private lateinit var llTwo: LinearLayout
    private lateinit var llThree: LinearLayout
    private lateinit var llFour: LinearLayout
    private lateinit var llFive: LinearLayout

    private lateinit var btnOne: TextView
    private lateinit var btnTwo: TextView
    private lateinit var btnThree: TextView
    private lateinit var btnFour: TextView
    private lateinit var btnAll: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_stock)

        ivSearch = findViewById(R.id.ivSearch)
        ivMenu = findViewById(R.id.ivMenu)
        tvSubTitle = findViewById(R.id.tvSubTitle)
        ivBell = findViewById(R.id.ivBell)

        llOne = findViewById(R.id.llOne)
        llTwo = findViewById(R.id.llTwo)
        llThree = findViewById(R.id.llThree)
        llFour = findViewById(R.id.llFour)
        llFive = findViewById(R.id.llFive)

        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnAll = findViewById(R.id.btnAll)

        setUI()

        setUI2()

        setClicks()
    }

    private fun setClicks() {
        ivMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        llOne.setOnClickListener {
            llOne.setBackgroundResource(R.drawable.rectangle_green_button)
            btnOne.setTextColor(Color.WHITE)

            llTwo.setBackgroundResource(R.drawable.rounded_rectangle)
            btnTwo.setTextColor(Color.BLACK)

            llThree.setBackgroundResource(R.drawable.rounded_rectangle)
            btnThree.setTextColor(Color.BLACK)

            llFour.setBackgroundResource(R.drawable.rounded_rectangle)
            btnFour.setTextColor(Color.BLACK)

            llFive.setBackgroundResource(R.drawable.rounded_rectangle)
            btnAll.setTextColor(Color.BLACK)

        }

        llTwo.setOnClickListener {
            llTwo.setBackgroundResource(R.drawable.rectangle_green_button)
            btnTwo.setTextColor(Color.WHITE)

            llOne.setBackgroundResource(R.drawable.rounded_rectangle)
            btnOne.setTextColor(Color.BLACK)

            llThree.setBackgroundResource(R.drawable.rounded_rectangle)
            btnThree.setTextColor(Color.BLACK)

            llFour.setBackgroundResource(R.drawable.rounded_rectangle)
            btnFour.setTextColor(Color.BLACK)

            llFive.setBackgroundResource(R.drawable.rounded_rectangle)
            btnAll.setTextColor(Color.BLACK)

        }

        llThree.setOnClickListener {
            llThree.setBackgroundResource(R.drawable.rectangle_green_button)
            btnThree.setTextColor(Color.WHITE)

            llOne.setBackgroundResource(R.drawable.rounded_rectangle)
            btnOne.setTextColor(Color.BLACK)

            llTwo.setBackgroundResource(R.drawable.rounded_rectangle)
            btnTwo.setTextColor(Color.BLACK)

            llFour.setBackgroundResource(R.drawable.rounded_rectangle)
            btnFour.setTextColor(Color.BLACK)

            llFive.setBackgroundResource(R.drawable.rounded_rectangle)
            btnAll.setTextColor(Color.BLACK)

        }

        llFour.setOnClickListener {
            llFour.setBackgroundResource(R.drawable.rectangle_green_button)
            btnFour.setTextColor(Color.WHITE)

            llOne.setBackgroundResource(R.drawable.rounded_rectangle)
            btnOne.setTextColor(Color.BLACK)

            llTwo.setBackgroundResource(R.drawable.rounded_rectangle)
            btnTwo.setTextColor(Color.BLACK)

            llThree.setBackgroundResource(R.drawable.rounded_rectangle)
            btnThree.setTextColor(Color.BLACK)

            llFive.setBackgroundResource(R.drawable.rounded_rectangle)
            btnAll.setTextColor(Color.BLACK)

        }

        llFive.setOnClickListener {
            llFive.setBackgroundResource(R.drawable.rectangle_green_button)
            btnAll.setTextColor(Color.WHITE)

            llOne.setBackgroundResource(R.drawable.rounded_rectangle)
            btnOne.setTextColor(Color.BLACK)

            llTwo.setBackgroundResource(R.drawable.rounded_rectangle)
            btnTwo.setTextColor(Color.BLACK)

            llThree.setBackgroundResource(R.drawable.rounded_rectangle)
            btnThree.setTextColor(Color.BLACK)

            llFour.setBackgroundResource(R.drawable.rounded_rectangle)
            btnFour.setTextColor(Color.BLACK)

        }
    }

    private fun setUI() {
        ivMenu.setImageResource(R.drawable.left)
        ivSearch.visibility = View.GONE
        tvSubTitle.text = "Stock Details"
        ivBell.setImageResource(R.drawable.download)
    }

    private fun setUI2() {
        val xValue = ArrayList<String>()
        xValue.add("Sun")
        xValue.add("Mon")
        xValue.add("Tue")
        xValue.add("Wed")
        xValue.add("Thu")
        xValue.add("Fri")
        xValue.add("Sat")
        xValue.add("Sun")
        xValue.add("Mon")
        xValue.add("Tue")
        xValue.add("Wed")
        xValue.add("Thu")
        xValue.add("Fri")
        xValue.add("")
        xValue.add("")
        xValue.add("")
        xValue.add("")

        val lineEntry = ArrayList<Entry>()
        lineEntry.add(Entry(10f, 1))
        lineEntry.add(Entry(100f, 2))
        lineEntry.add(Entry(50f, 3))
        lineEntry.add(Entry(300f, 4))
        lineEntry.add(Entry(10f, 5))
        lineEntry.add(Entry(500f, 6))
        lineEntry.add(Entry(900f, 7))
        lineEntry.add(Entry(550f, 8))
        lineEntry.add(Entry(120f, 6))
        lineEntry.add(Entry(1000f, 7))
        lineEntry.add(Entry(250f, 8))
        lineEntry.add(Entry(150f, 9))
        lineEntry.add(Entry(750f, 10))
        lineEntry.add(Entry(115f, 11))
        lineEntry.add(Entry(880f, 12))
        lineEntry.add(Entry(999f, 13))

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