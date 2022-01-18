package com.goncalojoaoc.birthdays.helpers

import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

open class UiTest {

    protected var webServer: MockWebServer? = null

    @Before
    fun server() {
        webServer = MockWebServer()
        webServer?.start(ApiTestRunner.MOCK_WEB_SERVER_PORT)
    }

    @After
    fun tearDown() {
        webServer?.shutdown()
    }
}