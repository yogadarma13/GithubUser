package com.yogadarma.consumerapp.persentation.fragments.follower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.consumerapp.R
import com.yogadarma.consumerapp.persentation.adapter.UserAdapter
import kotlinx.android.synthetic.main.fragment_follower.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FollowerFragment : Fragment() {

    companion object {
        private const val ARG_USERNAME = "username"

        fun newInstance(username: String?): FollowerFragment {
            val fragment = FollowerFragment()
            val bundle = Bundle()
            bundle.putString(ARG_USERNAME, username)
            fragment.arguments = bundle
            return fragment
        }
    }

    private val followerViewModel: FollowerViewModel by viewModel()
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = arguments?.getString(ARG_USERNAME)

        rv_follower_user.setHasFixedSize(true)

        username?.let { followerViewModel.setFollowerData(it) }

        followerViewModel.getFollowerData().observe(requireActivity(), Observer {
            if (it != null) {
                rv_follower_user.layoutManager = LinearLayoutManager(activity)
                userAdapter = UserAdapter(it)
                rv_follower_user.adapter = userAdapter
            }
        })
    }
}