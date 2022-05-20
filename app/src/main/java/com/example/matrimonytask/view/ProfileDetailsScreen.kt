package com.example.matrimonytask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.matrimonytask.R

class ProfileDetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.home_screen_top_bg)
        setContentView(R.layout.activity_profile_details_screen)

        val imageSlider = findViewById<ImageSlider>(R.id.img_profile)
        val imageList = ArrayList<SlideModel>()



        //imageList.add(SlideModel("https://images.immediate.co.uk/production/volatile/sites/3/2019/04/Avengers-Endgame-Banner-2-de7cf60.jpg?quality=90&resize=620,413","1/4"))
        //imageList.add(SlideModel("https://img.cinemablend.com/filter:scale/quill/3/7/0/0/8/e/37008e36e98cd75101cf1347396eac8534871a19.jpg?mw=600","2/4"))
        //imageList.add(SlideModel("https://www.adgully.com/img/800/201711/spider-man-homecoming-banner.jpg","3/4"))
        //imageList.add(SlideModel("https://live.staticflickr.com/1980/29996141587_7886795726_b.jpg","4/4"))



        val userName = intent.getStringExtra("userName")
        val userDetails = intent.getStringExtra("userDetails")
        val userImageURL = intent.getStringExtra("userImage")
        val txtUserName = findViewById<TextView>(R.id.txt_userName)
        val txtUserDetails = findViewById<TextView>(R.id.txt_userDetails)

        if (userImageURL != null){
            val url = userImageURL.substring(0, userImageURL.length-5)
            Log.e("Image","URL: "+url)

            for (i in 1..5){
                val image = i+1
                imageList.add(SlideModel("$url$image.jpg","$i/5"))
            }
            imageSlider.setImageList(imageList, ScaleTypes.FIT)
        }


        txtUserName.text = userName
        txtUserDetails.text = userDetails

        findViewById<ImageView>(R.id.img_back).setOnClickListener(View.OnClickListener {
            finish()
        })


    }
}