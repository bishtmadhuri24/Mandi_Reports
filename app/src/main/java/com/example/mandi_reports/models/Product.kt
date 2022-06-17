package com.example.mandi_reports.models

import java.io.Serializable

data class Product(
    val cmdtyID: String,
    val cmdtySegment: String,
    val cmdtyStdName: String,
    val picUrl: String,
    val posts: List<Post>,
    val sortOrder: Int,
    val translations: Translations
):Serializable