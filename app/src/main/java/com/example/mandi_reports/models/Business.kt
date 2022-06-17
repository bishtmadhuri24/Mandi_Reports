package com.example.mandi_reports.models

import java.io.Serializable

data class Business(
    val businessTypeId: Int,
    val category: String,
    val firmName: String,
    val mandiShopnum: String,
    val marketID: Int,
    val marketStdName: String,
    val userID: String,
    val userOption: String,
    val verificationStatus: String
): Serializable