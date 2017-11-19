package com.trickring.omikuji.model

import com.squareup.moshi.Json

/**
 * おみくじの結果　モデル
 */
data class OmikujiResult(
        @Json(name = "rank") val rank: Int,
        @Json(name = "message") val message: String
)