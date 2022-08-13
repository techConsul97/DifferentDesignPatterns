package com.sebqv97.differentdesignpatterns.data.models


import com.google.gson.annotations.SerializedName

data class GeoModel(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)