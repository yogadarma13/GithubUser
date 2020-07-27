package com.yogadarma.githubuser.persentation.activities.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import com.yogadarma.githubuser.persentation.activities.detail.DetailUserActivity
import com.yogadarma.githubuser.persentation.activities.favorite.FavoriteActivity
import com.yogadarma.githubuser.persentation.activities.setting.SettingActivity
import com.yogadarma.githubuser.persentation.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_user_github.setHasFixedSize(true)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv_user_github.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        sv_user_github.queryHint = resources.getString(R.string.search_hint)

        sv_user_github.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                progress_bar.visibility = View.VISIBLE
                query?.let { mainViewModel.setResultSearch(it) }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                progress_bar.visibility = View.VISIBLE
                newText?.let { mainViewModel.setResultSearch(it) }

                return true
            }
        })

        mainViewModel.getResultSearch().observe(this, Observer {
            if (it != null) {
                progress_bar.visibility = View.GONE
                rv_user_github.layoutManager = LinearLayoutManager(this)

                if (it.totalCount == 0) {
                    userAdapter = UserAdapter(ArrayList())
                } else {
                    userAdapter = UserAdapter(it.items)
                }

                rv_user_github.adapter = userAdapter

                setupListener()
            }
        })
    }

    private fun setupListener() {
        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallBack {
            override fun onItemClicked(user: UserData) {
                val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.ARG_USER_DATA, user)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_to_page_favorite -> {
                startActivity(Intent(this, FavoriteActivity::class.java))
            }

            R.id.action_change_language -> {
                startActivity(Intent(this, SettingActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        progress_bar.visibility = View.GONE
        super.onResume()
    }
}