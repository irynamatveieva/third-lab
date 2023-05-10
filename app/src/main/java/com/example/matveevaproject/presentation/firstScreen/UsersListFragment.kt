package com.example.matveevaproject.presentation.firstScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.matveevaproject.R

class UsersListFragment : Fragment() {
    lateinit var adapter: AdapterUsersList
    private var viewModel = UsersListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.users_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUserData()
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)
        swipe.setOnRefreshListener {
            getUserData()
            swipe.isRefreshing = false
        }
    }

    private fun getUserData() {
        viewModel = ViewModelProvider(this)[UsersListViewModel::class.java]

        viewModel.getData()

        viewModel.modelMutableLiveData.observe(viewLifecycleOwner) {
            adapter.getUsersList(it.users)
            if (it.users.isEmpty()) {
                Toast.makeText(context, "Lost Internet connection!", Toast.LENGTH_SHORT).show()
            }
        }

        adapter = AdapterUsersList { data, position ->
            viewModel.addUser(data.image, data.firstName, data.email)
            findNavController().navigate(R.id.mainToDescription, Bundle().apply {})
        }

        val rv = view?.findViewById<RecyclerView>(R.id.rv)
        rv?.adapter = adapter

        val layoutManager = LinearLayoutManager(context)
        rv?.layoutManager = layoutManager
    }
}