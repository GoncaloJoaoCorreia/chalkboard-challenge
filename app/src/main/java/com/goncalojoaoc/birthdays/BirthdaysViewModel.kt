package com.goncalojoaoc.birthdays

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.goncalojoaoc.birthdays.data.BirthdaysRepository
import com.goncalojoaoc.birthdays.model.Birthday

class BirthdaysViewModel(
    private val repository: BirthdaysRepository
) : ViewModel() {

    val birthdays: LiveData<List<Birthday>> = repository.getBirthdays()
}