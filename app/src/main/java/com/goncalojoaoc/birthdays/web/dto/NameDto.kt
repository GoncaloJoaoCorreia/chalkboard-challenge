package com.goncalojoaoc.birthdays.web.dto

import com.squareup.moshi.Json

data class NameDto(
    @field:Json(name = "first")
    val firstName: String,
    @field:Json(name = "last")
    val lastName: String
)
