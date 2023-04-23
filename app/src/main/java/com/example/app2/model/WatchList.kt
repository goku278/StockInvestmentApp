package com.example.app2.model

class WatchList {
    var icon: Int? = null
    var companyName: String? = null
    var percent: String? = null
    var bottomNumber: String? = null
    var valuation: String? = null
    var statIcon: Int? = null

    override fun toString(): String {
        return "WatchList(icon=$icon, companyName=$companyName, percent=$percent, bottomNumber=$bottomNumber, valuation=$valuation, statIcon=$statIcon)"
    }


}