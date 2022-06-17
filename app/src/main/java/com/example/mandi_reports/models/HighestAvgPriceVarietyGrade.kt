package com.example.mandi_reports.models

import java.io.Serializable

data class HighestAvgPriceVarietyGrade(
    val arrivalTotal: Int,
    val defaultGrade: Boolean,
    val defaultVariety: Boolean,
    val gradeDescr: String,
    val gradeID: String,
    val gradeName: String,
    val maxPrice: Int,
    val minPrice: Int,
    val varietyID: String,
    val varietyName: String
): Serializable