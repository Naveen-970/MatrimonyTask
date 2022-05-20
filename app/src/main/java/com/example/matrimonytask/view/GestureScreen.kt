package com.example.matrimonytask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matrimonytask.R
import com.example.matrimonytask.databinding.ActivityGestureScreenBinding
import com.example.matrimonytask.databinding.ActivityHomeScreenBinding
import com.example.matrimonytask.view.adapters.UserGestureProfilesAdapter
import com.example.matrimonytask.view.adapters.UserProfilesAdapter
import com.example.matrimonytask.viewmodel.HomeScreenViewModel

class GestureScreen : AppCompatActivity() {

    private lateinit var binding: ActivityGestureScreenBinding
    private lateinit var viewModel: HomeScreenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.gesture_screen_top_left)

        binding = ActivityGestureScreenBinding.inflate(layoutInflater)
        setContentView(binding.root )

        viewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java )

        viewModel.getAllProfiles()
        viewModel.mutableLiveData.observe(this, Observer {
            val manager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            binding.rvGesture.apply {
                adapter = UserGestureProfilesAdapter(it,this@GestureScreen)
                layoutManager = manager
            }
        })


        binding.imgBack.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}