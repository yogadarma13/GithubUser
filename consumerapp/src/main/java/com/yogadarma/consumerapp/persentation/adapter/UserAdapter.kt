package com.yogadarma.consumerapp.persentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogadarma.consumerapp.R
import com.yogadarma.consumerapp.domain.entity.UserData
import kotlinx.android.synthetic.main.layout_user.view.*

class UserAdapter(private val listUser: ArrayList<UserData>?) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_user, parent, false)

        return ViewHolder(
            viewHolder
        )
    }

    override fun getItemCount(): Int = listUser?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        listUser?.get(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: UserData) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(user.avatarUrl)
                    .apply(RequestOptions().override(55, 55))
                    .into(civ_user_image)
                tv_user_name.text = user.login
            }
        }
    }
}