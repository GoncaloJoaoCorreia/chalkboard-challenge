package com.goncalojoaoc.birthdays.helpers

import android.app.Application
import androidx.test.runner.AndroidJUnitRunner
import com.goncalojoaoc.birthdays.web.BirthdaysService
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiTestRunner : AndroidJUnitRunner() {

    override fun callApplicationOnCreate(app: Application?) {
        super.callApplicationOnCreate(app)
        // Override prod dependency with test one
        loadKoinModules(module {
            single { createTestWebService<BirthdaysService>() }
        })
    }

    private inline fun <reified T> createTestWebService(): T =
        Retrofit.Builder()
            .baseUrl("http://localhost:$MOCK_WEB_SERVER_PORT")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(T::class.java)


    companion object {
        const val MOCK_WEB_SERVER_PORT = 4007
    }
}