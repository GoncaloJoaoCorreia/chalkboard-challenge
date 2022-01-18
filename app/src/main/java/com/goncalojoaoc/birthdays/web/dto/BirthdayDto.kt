package com.goncalojoaoc.birthdays.web.dto

import com.squareup.moshi.Json

data class BirthdayDto(
    @field:Json(name = "name")
    val name: NameDto,
    @field:Json(name = "dob")
    val dateOfBirth: DateOfBirthDto
)
