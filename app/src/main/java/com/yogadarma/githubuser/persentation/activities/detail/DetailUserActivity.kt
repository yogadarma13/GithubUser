package com.yogadarma.githubuser.persentation.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.Favorite
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.persentation.adapter.SectionsPagerAdapter
import com.yogadarma.githubuser.util.toast
import kotlinx.android.synthetic.main.activity_detail_user.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailUserActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val ARG_USERNAME = "username"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var detailUserResponse: DetailUserResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        supportActionBar?.elevation = 0f
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val username = intent.getStringExtra(ARG_USERNAME)

        btn_favorite.setOnClickListener(this)

        detailViewModel.setDetailUser(username)

        detailViewModel.getDetailUser().observe(this, Observer {
            if (it != null) {
                detailUserResponse = it
                tv_user_name.text = it.name
                Glide.with(this).load(it.avatarUrl).into(civ_avatar_profile)
            }
        })

        detailViewModel.getFollowerUser().observe(this, Observer {
            if (it != null) {
                val countFollower = resources.getString(R.string.count_follower, it.size)
                tv_count_follower.text = countFollower
            }
        })

        detailViewModel.getFollowingUser().observe(this, Observer {
            if (it != null) {
                val countFollowing = resources.getString(R.string.count_following, it.size)
                tv_count_following.text = countFollowing
            }
        })

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        sectionsPagerAdapter.username = username
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_favorite -> {
                GlobalScope.launch {
                    detailViewModel.setFavoriteUser(
                        Favorite(
                            detailUserResponse.id!!,
                            detailUserResponse.login ?: "",
                            detailUserResponse.avatarUrl ?: "",
                            detailUserResponse.bio ?: "",
                            detailUserResponse.reposUrl ?: "",
                            detailUserResponse.followingUrl ?: "",
                            detailUserResponse.followersUrl ?: "",
                            detailUserResponse.company ?: ""
                        )
                    )
                }
                toast("Favorite ditambah")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}