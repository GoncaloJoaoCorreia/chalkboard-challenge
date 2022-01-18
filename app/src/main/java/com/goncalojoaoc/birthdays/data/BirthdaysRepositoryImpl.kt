package com.goncalojoaoc.birthdays.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.goncalojoaoc.birthdays.model.Birthday
import com.goncalojoaoc.birthdays.web.BirthdaysService
import kotlinx.coroutines.Dispatchers

class BirthdaysRepositoryImpl(
    private val service: BirthdaysService,
    private val mapper: BirthdaysDtoToModelMapper
) : BirthdaysRepository {

    override fun getBirthdays(): LiveData<List<Birthday>> = liveData(Dispatchers.IO) {
        try {
            emit(mapper.map(service.getBirthdays()))
        } catch (ex: Exception) {
            Log.e(this@BirthdaysRepositoryImpl::class.simpleName, ex.message, ex)
            // todo error handling with resource class
        }
    }
}