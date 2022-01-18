package com.goncalojoaoc.birthdays.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Birthday(
    val initials: String,
    val name: String,
    val dateOfBirth: String,
    val age: Int
): Parcelable
