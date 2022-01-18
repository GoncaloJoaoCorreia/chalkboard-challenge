package com.goncalojoaoc.birthdays.web.dto

import com.squareup.moshi.Json

data class DateOfBirthDto(
    @field:Json(name = "date")
    val date: String,
    @field:Json(name = "age")
    val age: Int
)
