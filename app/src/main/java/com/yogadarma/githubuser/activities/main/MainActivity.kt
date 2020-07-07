package com.yogadarma.githubuser.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.activities.detail.DetailUserActivity
import com.yogadarma.githubuser.adapter.UserAdapter
import com.yogadarma.githubuser.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainContract.View {
    private lateinit var mainPresenter: MainContract.Presenter
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter =
            MainPresenter(this)
        mainPresenter.requestDataUser()

        setupClickListener()
    }

    override fun populateGithubUser(list: ArrayList<User>) {
        recycler_view_user_list.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(list)
        recycler_view_user_list.adapter = userAdapter
    }

    fun setupClickListener() {
        userAdapter.setOnItemClickCallback(
            object : UserAdapter.OnItemClickCallBack {
                override fun onItemClicked(user: User) {
                    val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
                    intent.putExtra(DetailUserActivity.DATA_USER, user)
                    startActivity(intent)
                }

            }
        )
    }
}