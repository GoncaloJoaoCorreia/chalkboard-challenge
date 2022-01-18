package com.goncalojoaoc.birthdays.data

import androidx.lifecycle.LiveData
import com.goncalojoaoc.birthdays.model.Birthday

interface BirthdaysRepository {

    fun getBirthdays(): LiveData<List<Birthday>>
}
