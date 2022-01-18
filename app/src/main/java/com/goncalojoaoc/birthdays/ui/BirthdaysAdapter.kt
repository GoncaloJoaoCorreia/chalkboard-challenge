package com.goncalojoaoc.birthdays.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goncalojoaoc.birthdays.databinding.ViewBirthdayBinding
import com.goncalojoaoc.birthdays.model.Birthday

class BirthdaysAdapter(
    private val listener: BirthdayInteractions
) : RecyclerView.Adapter<BirthdayViewHolder>() {

    private var birthdays: List<Birthday> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun update(birthdays: List<Birthday>) {
        this.birthdays = birthdays
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthdayViewHolder =
        BirthdayViewHolder(
            ViewBirthdayBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: BirthdayViewHolder, position: Int) {
        holder.bind(birthdays[position], listener::onBirthdayClicked)
    }

    override fun getItemCount(): Int = birthdays.size
}

class BirthdayViewHolder(
    private val binding: ViewBirthdayBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(birthday: Birthday, onClick: (Birthday) -> Unit) = with(binding) {
        wrapper.setOnClickListener { onClick(birthday) }
        name.text = birthday.name
        avatar.text = birthday.initials
        dob.text = birthday.dateOfBirth
    }
}
