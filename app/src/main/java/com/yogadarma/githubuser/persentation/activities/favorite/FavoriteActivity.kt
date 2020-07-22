package com.yogadarma.githubuser.persentation.activities.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.persentation.activities.detail.DetailUserActivity
import com.yogadarma.githubuser.persentation.adapter.FavoriteAdapter
import com.yogadarma.githubuser.util.toast
import kotlinx.android.synthetic.main.activity_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = getString(R.string.favorite_page)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rv_user_favorite.setHasFixedSize(true)

        favoriteViewModel.allFavorite.observe(this, Observer {
            if (it != null) {
                rv_user_favorite.layoutManager = LinearLayoutManager(this)
                favoriteAdapter = FavoriteAdapter(it)
                rv_user_favorite.adapter = favoriteAdapter

                setupListener()
            }
        })
    }

    private fun setupListener() {
        favoriteAdapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallBack {
            override fun onItemClicked(user: UserData) {
                val intent = Intent(this@FavoriteActivity, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.ARG_USER_DATA, user)
                startActivity(intent)
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}