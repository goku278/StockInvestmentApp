package com.example.app2.model

class StocksActivity {
    var icon: Int? = null
    var companyName: String? = null
    var bottomNumber: String? = null
    var percent: String? = null
    var valuation: String? = null
    var shares: String? = null

    override fun toString(): String {
        return "StocksActivity(icon=$icon, companyName=$companyName, bottomNumber=$bottomNumber, percent=$percent, valuation=$valuation, shares=$shares)"
    }


}