package com.trickring.omikuji.api

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.trickring.omikuji.BuildConfig
import com.trickring.omikuji.model.OmikujiResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

/**
 * おみくじ API
 */
interface OmikujiApi {

    /**
     * シングルトン
     */
    companion object {

        /**
         * 自己インスタンス
         */
        private var omikujiApi: OmikujiApi? = null

        /**
         * APIを生成
         *
         * @return OmikujiApi
         */
        fun create(): OmikujiApi {
            if (omikujiApi == null) {
                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()

                val retrofit = Retrofit.Builder()
                        .baseUrl(BuildConfig.API_ENDPOINT)
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build()
                omikujiApi = retrofit.create(OmikujiApi::class.java)
            }
            return requireNotNull(omikujiApi) { "Omikuji Api is null !!" }
        }
    }

    /**
     * リクエスト
     *
     * @return Call
     */
    @GET("omikuji")
    fun requestOmikujiApi(): Call<OmikujiResult>
}