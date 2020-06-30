package com.dragonbro.hunters.data

import com.google.gson.annotations.SerializedName

data class ThirdHunterData(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("thumbnail") val thumbnail: String = "",
    @SerializedName("special_part") val specialPart: String = "",
    @SerializedName("grade") val grade: String = "",
    @SerializedName("like_cnt") val likeCnt: String = "",
    @SerializedName("consult_cnt") val consultCnt: String = "",
    @SerializedName("review_lists") val reviewList: MutableList<String>
)