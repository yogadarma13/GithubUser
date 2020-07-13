package com.yogadarma.githubuser.persentation.activities.main

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.responses.UserData
import com.yogadarma.githubuser.persentation.activities.detail.DetailUserActivity
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
                userAdapter = UserAdapter(it.items)
                rv_user_github.adapter = userAdapter

                setupListener()
            }
        })
    }

    private fun setupListener() {
        userAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallBack {
            override fun onItemClicked(user: UserData) {
                val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
                intent.putExtra(DetailUserActivity.ARG_USERNAME, user.login)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_language) {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}