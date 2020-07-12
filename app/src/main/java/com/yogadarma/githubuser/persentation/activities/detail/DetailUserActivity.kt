package com.yogadarma.githubuser.persentation.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.persentation.adapter.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_detail_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailUserActivity : AppCompatActivity() {

    companion object {
        const val ARG_USERNAME = "username"
    }

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        supportActionBar?.elevation = 0f

        val username = intent.getStringExtra(ARG_USERNAME)

        detailViewModel.setDetailUser(username)

        detailViewModel.getDetailUser().observe(this, Observer {
            if (it != null) {
                tv_user_name.text = it.name
                Glide.with(this).load(it.avatarUrl).into(civ_avatar_profile)
            }
        })

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        sectionsPagerAdapter.username = username
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }
}