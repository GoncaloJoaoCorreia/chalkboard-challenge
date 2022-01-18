package com.goncalojoaoc.birthdays.data

import com.goncalojoaoc.birthdays.model.Birthday
import com.goncalojoaoc.birthdays.web.dto.BirthdayDto
import com.goncalojoaoc.birthdays.web.dto.DateOfBirthDto
import com.goncalojoaoc.birthdays.web.dto.NameDto
import com.goncalojoaoc.birthdays.web.dto.ResultsDto
import org.junit.Assert.*
import org.junit.Test

class BirthdaysDtoToModelMapperTest {

    @Test
    fun testDtoToModelMapping() {
        val mapper = BirthdaysDtoToModelMapper()

        val birthdayDto = BirthdayDto(
            name = NameDto(
                firstName = "John",
                lastName = "Doe"
            ),
            dateOfBirth = DateOfBirthDto(
                date = "1980-02-26T07:16:39.510Z",
                age = 42
            )
        )
        val resultsDto = ResultsDto(listOf(birthdayDto))

        val expected = listOf(
            Birthday(
                initials = "JD",
                name = "John Doe",
                dateOfBirth = "1980-02-26",
                age = 42
            )
        )

        val result = mapper.map(resultsDto)

        assertEquals(expected, result)
    }
}