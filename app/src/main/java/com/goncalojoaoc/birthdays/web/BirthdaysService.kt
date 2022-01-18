package com.goncalojoaoc.birthdays.web

import com.goncalojoaoc.birthdays.web.dto.ResultsDto
import retrofit2.http.GET

interface BirthdaysService {
    @GET("api/?results=1000&seed=chalkboard&inc=name,dob")
    suspend fun getBirthdays(): ResultsDto
}
