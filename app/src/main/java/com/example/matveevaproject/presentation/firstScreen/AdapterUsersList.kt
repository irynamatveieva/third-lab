package com.example.matveevaproject.presentation.firstScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matveevaproject.data.remote.model.Users
import com.example.matveevaproject.databinding.UserCardBinding

class AdapterUsersList(val onClick: (users: Users, position: Int) -> Unit) :
    RecyclerView.Adapter<AdapterUsersList.UserViewHolder>() {
    private val usersList = ArrayList<Users>()

    inner class UserViewHolder(val binding: UserCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindUser(users: Users, position: Int) {
            binding.tvName.text = users.firstName
            binding.tvEmail.text = users.email

            binding.button.setOnClickListener {
                onClick(users, position)
            }

            Glide.with(binding.imageView.context)
                .load(users.image)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(usersList[position], position)
    }

    fun getUsersList(newList: List<Users>) {
        usersList.clear()
        usersList.addAll(newList)
        notifyDataSetChanged()
    }
}