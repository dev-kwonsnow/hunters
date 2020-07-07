package com.dragonbro.hunters.data

import com.google.gson.annotations.SerializedName

data class HunterInfo(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("thumbnail") val thumbnail: String = "",
    @SerializedName("special_part") val specialPart: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("keyword_list") val keywordList: List<String> = arrayListOf(),
    @SerializedName("matching_keyword_list") val matchingKeywordList: List<String> = arrayListOf(),
    @SerializedName("matching_percent_num") val matchingPercentNum: Int = 0,
    @SerializedName("grade") val grade: String = "",
    @SerializedName("follow_cnt") val followCnt: String = "",
    @SerializedName("consult_request_cnt") val consultRequestCnt: String = "",
    @SerializedName("consult_complete_cnt") val consultCompleteCnt: String = ""
)