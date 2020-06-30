package com.dragonbro.hunters.data

import com.google.gson.annotations.SerializedName

data class SecondHunterData(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("thumbnail") val thumbnail: String = "",
    @SerializedName("special_part") val specialPart: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("grade") val grade: String = "",
    @SerializedName("like_cnt") val likeCnt: String = "",
    @SerializedName("follower_cnt") val followerCnt: String = ""
)