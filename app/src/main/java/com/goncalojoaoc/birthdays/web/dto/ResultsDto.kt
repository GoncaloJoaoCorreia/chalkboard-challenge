package com.goncalojoaoc.birthdays.web.dto

import com.squareup.moshi.Json

data class ResultsDto(
    @field:Json(name = "results")
    val results: List<BirthdayDto>
)
