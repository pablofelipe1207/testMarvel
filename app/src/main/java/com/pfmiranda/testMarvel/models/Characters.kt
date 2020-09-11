package com.pfmiranda.testMarvel.models

import com.google.gson.annotations.SerializedName

data class Characters (

    @SerializedName("code") val code : String,
    @SerializedName("status") val status : String,
    @SerializedName("copyright") val copyright : String,
    @SerializedName("attributionText") val attributionText : String,
    @SerializedName("attributionHTML") val attributionHTML : String,
    @SerializedName("data") val data : Data,
    @SerializedName("etag") val etag : String
)