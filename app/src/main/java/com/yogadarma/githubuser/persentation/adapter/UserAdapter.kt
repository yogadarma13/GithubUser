package com.yogadarma.githubuser.persentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.domain.entity.UserData
import kotlinx.android.synthetic.main.layout_user.view.*

class UserAdapter(private val listUser: ArrayList<UserData>?) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

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
                itemView.setOnClickListener { onItemClickCallBack?.onItemClicked(user) }
            }
        }
    }

    interface OnItemClickCallBack {
        fun onItemClicked(user: UserData)
    }
}