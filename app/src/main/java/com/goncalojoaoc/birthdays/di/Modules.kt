package com.goncalojoaoc.birthdays.di

import com.goncalojoaoc.birthdays.ui.BirthdaysViewModel
import com.goncalojoaoc.birthdays.data.BirthdaysDtoToModelMapper
import com.goncalojoaoc.birthdays.data.BirthdaysRepository
import com.goncalojoaoc.birthdays.data.BirthdaysRepositoryImpl
import com.goncalojoaoc.birthdays.web.BirthdaysService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single<BirthdaysService> {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/") // fixme move to resource
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(BirthdaysService::class.java)
    }

    single<BirthdaysRepository> { BirthdaysRepositoryImpl(get(), get()) }

    single { BirthdaysDtoToModelMapper() }

    viewModel { BirthdaysViewModel(get()) }
}