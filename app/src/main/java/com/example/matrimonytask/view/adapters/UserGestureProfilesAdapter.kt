package com.example.matrimonytask.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.matrimonytask.databinding.LayoutGestureItemBinding
import com.example.matrimonytask.databinding.LayoutRecyclerViewItemBinding
import com.example.matrimonytask.model.UserProfile
import com.example.matrimonytask.view.ProfileDetailsScreen
import com.squareup.picasso.Picasso

class UserGestureProfilesAdapter(private var profilesList: ArrayList<UserProfile>,
                                 private val context: Context) :
    RecyclerView.Adapter<UserGestureProfilesAdapter.MyViewHolder>() {

    inner class MyViewHolder(public val binding: LayoutGestureItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userProfile: UserProfile) {
            binding.userProfile = userProfile
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val recyclerViewItem = LayoutGestureItemBinding.inflate(inflater,parent,false)
        return MyViewHolder(recyclerViewItem)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(profilesList[position])

        holder.binding.imgDone.setOnClickListener {
            Toast.makeText(context,profilesList[position].userName+" Removed",Toast.LENGTH_SHORT).show()
            profilesList.removeAt(position)
            notifyItemRangeRemoved(position,profilesList.size)
        }
        holder.binding.imgClose.setOnClickListener {
            Toast.makeText(context,profilesList[position].userName+" Removed",Toast.LENGTH_SHORT).show()
            profilesList.removeAt(position)
            notifyItemRangeRemoved(position,profilesList.size)
        }
    }

    override fun getItemCount(): Int {
        return profilesList.size
    }

}