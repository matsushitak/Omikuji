package com.trickring.omikuji.avtivity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.trickring.omikuji.R
import com.trickring.omikuji.api.OmikujiApi
import com.trickring.omikuji.databinding.ActivityMainBinding
import com.trickring.omikuji.model.OmikujiResult
import com.trickring.omikuji.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    /**
     * ログ出力用
     */
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = MainViewModel()

        // ボタンを押下
        binding.omikujiButton.setOnClickListener {
            // おみくじAPIの呼び出し
            OmikujiApi.create().requestOmikujiApi().enqueue(object : Callback<OmikujiResult> {
                override fun onResponse(call: Call<OmikujiResult>?, response: Response<OmikujiResult>?) {
                    // 成功
                    Log.d(TAG, "onResponse ${response?.body().toString()}")
                    // ViewModelを更新
                    binding.viewModel?.omikujiResult = response?.body()
                }

                override fun onFailure(call: Call<OmikujiResult>?, t: Throwable?) {
                    // 失敗
                    Log.e(TAG, "onFailure", t)
                }
            })
        }
    }
}
