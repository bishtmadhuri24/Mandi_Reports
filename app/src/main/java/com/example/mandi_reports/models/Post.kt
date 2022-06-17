package com.example.mandi_reports.models

import java.io.Serializable

data class Post(
    val _id: String,
    val cmdtyID: String,
    val cmdtyStdName: String,
    val computed: Computed,
    val contentType: String,
    val createdAt: String,
    val dateOfReport: String,
    val loclevel2: Int,
    val loclevel2ShortName: String,
    val loclevel3: Int,
    val loclevel3Name: String,
    val marketID: Int,
    val marketStdName: String,
    val marketType: String,
    val priceDetails: List<PriceDetail>,
    val rawPriceConvFctr: Int,
    val rawReportPriceUnit: String,
    val rawReportPriceUnitID: String,
    val reportID: String,
    val updatedAt: String
): Serializable