package com.example.bf_kotlin_client.utils

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

@BindingAdapter("android:image_bitmap")
fun setImageBitmap(
    imageView: ImageView, bitmap: Bitmap,
) {
    imageView.setImageBitmap(bitmap)
}

@BindingAdapter("android:is_refresh")
fun setRefresh(
    swipeRefreshLayout: SwipeRefreshLayout, value: Boolean,
) {
    swipeRefreshLayout.isRefreshing = value
}

@BindingAdapter("android:on_refresh")
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    listener: SwipeRefreshLayout.OnRefreshListener?,
) {
    if (listener != null) {
        swipeRefreshLayout.setOnRefreshListener(listener)
    }
}
@BindingAdapter("android:onItemSelected")
fun setOnItemSelected(
    bottomNavigationView: BottomNavigationView,
    listener: NavigationBarView.OnItemSelectedListener?,
) {
    if (listener != null) {
        bottomNavigationView.setOnItemSelectedListener(listener)
    }
}

@BindingAdapter("android:onBackPressed")
fun onBackPressed(view: View, callback:OnBackPressedCallback?){
    var activity= view.context as AppCompatActivity
    if (callback != null) {
        activity.onBackPressedDispatcher.addCallback(callback)
    }
}