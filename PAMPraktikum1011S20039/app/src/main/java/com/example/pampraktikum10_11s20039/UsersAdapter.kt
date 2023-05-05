package com.example.pampraktikum10_11s20039

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pampraktikum10_11s20039.databinding.UsersItemBinding

class UsersAdapter(
    var context: Context,
    var userList : ArrayList<User>
) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    inner class UsersViewHolder(val adapterBinding: UsersItemBinding) :
            RecyclerView.ViewHolder(adapterBinding.root){

            }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = UsersItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UsersViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UsersViewHolder, position: Int) {
        val user : User = userList[position];
        holder.adapterBinding.tvName.text = user.name
        holder.adapterBinding.tvEmail.text = user.email
        holder.adapterBinding.tvPassword.text = user.password

        holder.adapterBinding.llUser.setOnClickListener {
            val intent = Intent(
                context, UpdateUserActivity::class.java)
            intent.putExtra("id", user.id)
            intent.putExtra("name", user.name)
            intent.putExtra("email", user.email)
            intent.putExtra("password", user.password)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun getUserId(position: Int) : String{
        return userList[position].id
    }
}