package com.example.matrimonytask.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("userImageURL")
fun loadImage(view: View,
              imageUrl: String?) {
    val image: ImageView = view as ImageView
    Picasso.get().load(imageUrl)
        .resize(300,300)
        .into(image)
}