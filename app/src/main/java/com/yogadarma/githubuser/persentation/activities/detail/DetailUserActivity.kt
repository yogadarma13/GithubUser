package com.yogadarma.githubuser.persentation.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.yogadarma.githubuser.R
import kotlinx.android.synthetic.main.activity_detail_user.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailUserActivity : AppCompatActivity() {

    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)


        btn_test.setOnClickListener {
            detailViewModel.setDetailUser("yogadarma13")
        }

        detailViewModel.getDetailUser().observe(this, Observer {
            if (it != null) {
                tv_name.text = it.name
            }
        })
    }
}