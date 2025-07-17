package com.skyd.imomoe.util.coil

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.skyd.imomoe.R
import com.skyd.imomoe.config.Api.Companion.MAIN_URL
import com.skyd.imomoe.util.Util.showToastOnIOThread


object CoilUtil {
    init {

    }

    fun ImageView.loadImage(url: String) {
        if (url.isEmpty()) {
            "cover image url must not be null or empty".showToastOnIOThread()
            return
        }

        Glide.with(this).load(url).into(this)
//        this.load(url, builder = builder)
    }

    fun ImageView.loadImage(
        url: String,
        referer: String? = null,
        @DrawableRes placeholder: Int = 0,
        @DrawableRes error: Int = R.drawable.ic_warning_main_color_3_24_skin
    ) {
        var amendReferer = referer
        if (amendReferer?.startsWith(MAIN_URL) == false)
            amendReferer = MAIN_URL//"http://www.yhdm.io/"
        if (referer == MAIN_URL || referer == MAIN_URL) amendReferer += "/"

        Glide.with(this).load(url).placeholder(placeholder).error(error).into(this)
    }


    fun clearMemoryDiskCache(ctx: Context) {
        Glide.get(ctx).clearMemory()
        Glide.get(ctx).clearDiskCache()
    }
}