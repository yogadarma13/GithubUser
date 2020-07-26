package com.yogadarma.githubuser.persentation.activities.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.domain.responses.DetailUserResponse
import com.yogadarma.githubuser.helper.MappingHelper
import com.yogadarma.githubuser.persentation.adapter.SectionsPagerAdapter
import com.yogadarma.githubuser.util.toast
import kotlinx.android.synthetic.main.activity_detail_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailUserActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val ARG_USER_DATA = "user_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private var statusFavorite: Boolean = false
    private lateinit var detailUserResponse: DetailUserResponse
    private lateinit var userData: UserData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.detail_page)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        img_favorite.setOnClickListener(this)

        userData = intent.getParcelableExtra(ARG_USER_DATA)

        userData.login?.let { detailViewModel.setDetailUser(it) }

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

        userData.id?.let { detailViewModel.setFavoriteById(it) }

        detailViewModel.getFavoriteById().observe(this, Observer {
            if (it.count >= 1) {
                statusFavorite = true
            }
            setStatusFavorite(statusFavorite)
        })

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        sectionsPagerAdapter.username = userData.login
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_favorite -> {
                statusFavorite = !statusFavorite
                setStatusFavorite(statusFavorite)
                setFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(status: Boolean) {
        if (status)
            img_favorite.setImageResource(R.drawable.ic_favorite_true)
        else
            img_favorite.setImageResource(R.drawable.ic_favorite_false)
    }

    private fun setFavorite(status: Boolean) {
        if (status) {
            val content = MappingHelper.convertToContentValues(userData)
            detailViewModel.setFavoriteUser(
                content
            )

            toast(getString(R.string.add_favorite))
        } else {
            detailViewModel.deleteFavoriteUser(
                userData.id!!
            )
            toast(getString(R.string.cancel_favorite))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}