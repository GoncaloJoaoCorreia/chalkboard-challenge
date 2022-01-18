package com.goncalojoaoc.birthdays.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.goncalojoaoc.birthdays.R
import com.goncalojoaoc.birthdays.databinding.ActivityDetailsBinding
import com.goncalojoaoc.birthdays.model.Birthday

class DetailsActivity : Activity() {

    companion object {
        private const val EXTRA_BIRTHDAY = "BIRTHDAY"

        fun launch(context: Context, birthday: Birthday) {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra(EXTRA_BIRTHDAY, birthday)
            }
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.setHomeButtonEnabled(true)

        prepareViews(intent.getParcelableExtra(EXTRA_BIRTHDAY))
    }

    private fun prepareViews(birthday: Birthday?) = with(binding) {
        avatar.text = birthday?.initials.orEmpty()
        name.text = birthday?.name.orEmpty()
        age.text = getString(R.string.age_label, birthday?.age ?: 0)
        backButton.setOnClickListener { onBackPressed() }
    }

}
