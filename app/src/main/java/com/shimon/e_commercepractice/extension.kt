package com.shimon.e_commercepractice

import android.widget.ImageView
import coil3.load
import coil3.request.CachePolicy
import coil3.request.error
import coil3.request.placeholder


fun ImageView.loadImage(imageUrl: String) {
    this.load(imageUrl) {
        placeholder(R.drawable.place_holder)
        error(R.drawable.error)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}
