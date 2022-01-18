package com.goncalojoaoc.birthdays.data

import com.goncalojoaoc.birthdays.model.Birthday
import com.goncalojoaoc.birthdays.web.dto.NameDto
import com.goncalojoaoc.birthdays.web.dto.ResultsDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class BirthdaysDtoToModelMapper {

    fun map(resultsDto: ResultsDto) = resultsDto.results.map {
        Birthday(
            name = mapName(it.name),
            initials = mapInitials(it.name),
            dateOfBirth = mapDate(it.dateOfBirth.date),
            age = it.dateOfBirth.age
        )
    }

    private fun mapName(name: NameDto) = "${name.firstName} ${name.lastName}"

    private fun mapInitials(name: NameDto) =
        "${name.firstName.first().uppercase()}${name.lastName.first().uppercase()}"

    private fun mapDate(date: String): String =
        LocalDate.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .format(DateTimeFormatter.ISO_LOCAL_DATE)
}