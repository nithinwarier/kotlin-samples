package com.androidians.showlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class UsersAdapter(private val items : ArrayList<User>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = LayoutInflater.from(parent?.context).inflate(R.layout.row, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var user = items[position];
        holder?.txtName?.text = user.name
        holder?.txtComment?.text = user.email
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var txtName : TextView? = null
        var txtComment : TextView? = null

        init {
            this.txtName = row?.findViewById<TextView>(R.id.tv_name)
            this.txtComment = row?.findViewById<TextView>(R.id.tv_comment)
        }
    }

}


