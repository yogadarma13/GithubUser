package com.yogadarma.githubuser.persentation.fragments.following

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.persentation.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_following.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FollowingFragment : Fragment() {

    companion object {
        private val ARG_USERNAME = "username"

        fun newInstance(username: String?): FollowingFragment {
            val fragment = FollowingFragment()
            val bundle = Bundle()
            bundle.putString(ARG_USERNAME, username)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val followingViewModel: FollowingViewModel by viewModel()
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_following, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString(ARG_USERNAME)

        rv_following_user.setHasFixedSize(true)

        username?.let { followingViewModel.setFollowingData(it) }

        followingViewModel.getFollowingData().observe(requireActivity(), Observer {
            if (it != null) {
                rv_following_user.layoutManager = LinearLayoutManager(activity)
                userAdapter = UserAdapter(it)
                rv_following_user.adapter = userAdapter
            }
        })
    }
}