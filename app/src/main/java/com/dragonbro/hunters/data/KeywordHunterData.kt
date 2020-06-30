package com.dragonbro.hunters.data

import com.google.gson.annotations.SerializedName

data class KeywordHunterData(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("thumbnail") val thumbnail: String = "",
    @SerializedName("special_part") val specialPart: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("keyword_list") val keywordList: List<String> = arrayListOf(),
    @SerializedName("matching_percent_num") val matchingPercentNum: String = "",
    @SerializedName("grade") val grade: String = "",
    @SerializedName("consult_cnt") val consultCnt: String = ""
)