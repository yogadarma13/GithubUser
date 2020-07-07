package com.yogadarma.githubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogadarma.githubuser.R
import com.yogadarma.githubuser.models.User
import kotlinx.android.synthetic.main.layout_user.view.*

class UserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var onItemClickCallBack: OnItemClickCallBack

    interface OnItemClickCallBack {
        fun onItemClicked(user: User)
    }

    fun setOnItemClickCallback(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_user, parent, false)

        return ViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = listUser.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_user_name.text = listUser[position].name
        holder.itemView.tv_user_company.text = listUser[position].company
        holder.itemView.civ_user_image.setImageResource(listUser[position].avatar)

        holder.itemView.setOnClickListener {
            onItemClickCallBack.onItemClicked(listUser[holder.adapterPosition])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}