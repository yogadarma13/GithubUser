package com.yogadarma.consumerapp.persentation.activities.favorite

import android.content.Intent
import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.consumerapp.R
import com.yogadarma.consumerapp.data.db.ContentUri.Companion.CONTENT_URI
import com.yogadarma.consumerapp.domain.entity.UserData
import com.yogadarma.consumerapp.persentation.activities.detail.DetailUserActivity
import com.yogadarma.consumerapp.persentation.adapter.FavoriteAdapter
import com.yogadarma.consumerapp.util.toast
import kotlinx.android.synthetic.main.activity_favorite.*
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

        rv_user_favorite.layoutManager = LinearLayoutManager(this)
        rv_user_favorite.setHasFixedSize(true)
        favoriteAdapter = FavoriteAdapter()
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
        favoriteViewModel.setFavoriteList()

        favoriteViewModel.getFavoriteList().observe(this, Observer {
            if (it != null) {
                if (it.size > 0) {
                    img_no_data.visibility = View.GONE
                    favoriteAdapter.listFavorite = it
                } else {
                    img_no_data.visibility = View.VISIBLE
                    favoriteAdapter.listFavorite = ArrayList()
                    toast(getString(R.string.no_data))
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(EXTRA_STATE, favoriteAdapter.listFavorite)
    }
}