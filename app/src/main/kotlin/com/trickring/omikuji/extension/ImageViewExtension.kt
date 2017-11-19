package com.trickring.omikuji.extension

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * ImageView 拡張クラス
 */
object ImageViewExtension {

    /**
     * 画像リソースを表示
     */
    @JvmStatic
    @BindingAdapter("imageResource")
    fun setImageResource(imageView: ImageView, resource: Int?) {
        resource?.let { imageView.setImageResource(it) }
    }
}