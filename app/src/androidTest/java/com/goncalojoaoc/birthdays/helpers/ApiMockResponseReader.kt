package com.goncalojoaoc.birthdays.helpers

import androidx.test.platform.app.InstrumentationRegistry

class ApiMockResponseReader(private val id: Int) {
    fun getContent(): String {
        return InstrumentationRegistry.getInstrumentation().targetContext.resources.openRawResource(id)
            .readBytes().toString(Charsets.UTF_8)
    }
}
