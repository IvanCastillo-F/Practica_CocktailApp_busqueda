package com.amalip.cocktailapp.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.amalip.cocktailapp.R

/**
 * Created by Amalip on 10/1/2021.
 */

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromURL(url: String) = this.load(url) {
    crossfade(true)
    placeholder(R.drawable.ic_cocktails)
    transformations(CircleCropTransformation())
}