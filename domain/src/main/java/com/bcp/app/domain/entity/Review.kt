package com.bcp.app.domain.entity

import java.util.*

data class Review(
    var consumer: String,
    var stars: Int,
    var date: Date,
    var content: String)