package com.trickring.omikuji.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import com.trickring.omikuji.BR
import com.trickring.omikuji.R
import com.trickring.omikuji.model.OmikujiResult

/**
 * メイン画面　ViewModel
 */
class MainViewModel : BaseObservable() {

    /**
     * ログ出力用
     */
    private val TAG = MainViewModel::class.java.simpleName

    /**
     * おみくじ結果 Model
     */
    var omikujiResult: OmikujiResult? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.message)
            notifyPropertyChanged(BR.imageResource)
        }

    /**
     * メッセージを取得
     *
     * @return String
     */
    @Bindable
    fun getMessage(): String? {
        Log.d(TAG, "メッセージを取得")
        return omikujiResult?.message
    }

    /**
     * 画像リソースを取得
     *
     * @return Int
     */
    @Bindable
    fun getImageResource(): Int? {
        Log.d(TAG, "画像を取得")
        return when (omikujiResult?.rank) {
            0 -> R.mipmap.daikichi
            1 -> R.mipmap.chukichi
            2 -> R.mipmap.kichi
            3 -> R.mipmap.kyo
            else -> 0
        }
    }
}