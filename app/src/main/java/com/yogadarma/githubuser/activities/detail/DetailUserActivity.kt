package com.yogadarma.githubuser.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.models.User
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {
    companion object {
        const val DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        actionBar?.title = "Detail User"
        supportActionBar?.title = "Detail User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val user = intent.getParcelableExtra(DATA_USER) as User

        img_avatar_profile.setImageResource(user.avatar)
        tv_name_profile.text = user.name
        tv_username_profile.text = user.username
        tv_company_profile.text = user.company
        tv_location_profile.text = user.location
        tv_repository_profile.text = user.repository.toString()
        tv_follower_profile.text = user.follower.toString()
        tv_following_profile.text = user.following.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}