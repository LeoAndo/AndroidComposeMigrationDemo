package com.leoleo.androidcomposemigrationdemo.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leoleo.androidcomposemigrationdemo.R
import com.leoleo.androidcomposemigrationdemo.data.User

class MyListAdapter() : ListAdapter<User, MyListAdapter.VH>(ITEM_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, parent, false)
        return VH(item)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            val name = itemView.findViewById<TextView>(R.id.name)
            name.text = user.name
            val age = itemView.findViewById<TextView>(R.id.age)
            age.text = user.age.toString()
        }
    }
}

private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}