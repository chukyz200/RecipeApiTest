package apps.cz200dev.technictestapp.utils

import android.view.View
import android.widget.ImageView
import apps.cz200dev.technictestapp.R
import com.bumptech.glide.Glide

//Extension function to load a Glide image
fun ImageView.loadImage(url: String) {
    Glide.with(this.context).load(url)
        .error(R.drawable.ic_baseline_broken_image_24)
        .into(this)
}

//Unhide a view
fun View.visible() {
    this.visibility = View.VISIBLE
}

//Hide a view again
fun View.invisible() {
    this.visibility = View.GONE
}