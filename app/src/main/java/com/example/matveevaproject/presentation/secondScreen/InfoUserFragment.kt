package com.example.matveevaproject.presentation.secondScreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.matveevaproject.R
import com.example.matveevaproject.data.local.model.UserModel

class InfoUserFragment : Fragment() {

    private val userModels = ArrayList<UserModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_user_fragment, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewModel = ViewModelProvider(this)[InfoUserViewModel::class.java]
        userModels.clear()
        userModels.addAll(viewModel.getUser())

        val tvEmail = view.findViewById<TextView>(R.id.email)
        tvEmail.text = userModels[0].email

        val tvFirstName = view.findViewById<TextView>(R.id.firstName)
        tvFirstName.text = userModels[0].firstName

        val ivImage = view.findViewById<ImageView>(R.id.userImage)
        Glide.with(ivImage.context)
            .load(userModels[0].image)
            .into(ivImage)
    }
}