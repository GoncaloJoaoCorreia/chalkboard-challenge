package com.goncalojoaoc.birthdays.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.goncalojoaoc.birthdays.databinding.ActivityBirthdaysBinding
import com.goncalojoaoc.birthdays.model.Birthday

class BirthdaysActivity : AppCompatActivity(), BirthdayInteractions {

    private val viewModel: BirthdaysViewModel by viewModel()

    private lateinit var binding: ActivityBirthdaysBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBirthdaysBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()
    }

    private fun prepareRecyclerView() {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(
                this@BirthdaysActivity,
                RecyclerView.VERTICAL,
                false
            )
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    this@BirthdaysActivity,
                    RecyclerView.VERTICAL
                )
            )

            val adapter = BirthdaysAdapter(this@BirthdaysActivity)
            recyclerView.adapter = adapter

            viewModel.birthdays.observe(this@BirthdaysActivity, {
                adapter.update(it)
            })
        }
    }

    override fun onBirthdayClicked(birthday: Birthday) {
        DetailsActivity.launch(this, birthday)
    }
}
