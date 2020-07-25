package com.yogadarma.githubuser.persentation.activities.favorite

import android.content.Intent
import android.database.ContentObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.persentation.activities.detail.DetailUserActivity
import com.yogadarma.githubuser.persentation.adapter.FavoriteAdapter
import com.yogadarma.githubuser.provider.GithubUserProvider.Companion.CONTENT_URI
import com.yogadarma.githubuser.util.toast
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_STATE = "EXTRA_STATE"
    }

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = getString(R.string.favorite_page)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rv_user_favorite.layoutManager = LinearLayoutManager(this)
        rv_user_favorite.setHasFixedSize(true)
        favoriteAdapter = FavoriteAdapter(this)
        rv_user_favorite.adapter = favoriteAdapter


        val handler = Handler(Looper.getMainLooper())

        val myObserver = object : ContentObserver(handler) {
            override fun onChange(self: Boolean) {
                loadFavoritesAsync()
            }
        }

        contentResolver.registerContentObserver(CONTENT_URI, true, myObserver)

        if (savedInstanceState == null) {
            loadFavoritesAsync()
        } else {
            val list = savedInstanceState.getParcelableArrayList<UserData>(EXTRA_STATE)
            if (list != null) {
                favoriteAdapter.listFavorite = list
            }
        }

    }

    private fun loadFavoritesAsync() {
        progress_bar_favorite.visibility = View.VISIBLE
//        GlobalScope.launch(Dispatchers.IO) {
            favoriteViewModel.setFavoriteList()
//        }

        favoriteViewModel.getFavoriteList().observe(this, Observer {
            if (it != null) {
                progress_bar_favorite.visibility = View.GONE
                toast(it.size.toString())
                if (it.size > 0) {
                    favoriteAdapter.listFavorite = it
                } else {
                    favoriteAdapter.listFavorite = ArrayList()
                    toast("tidak ada data")
                }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, favoriteAdapter.listFavorite)
    }
}