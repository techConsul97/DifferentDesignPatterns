package com.sebqv97.differentdesignpatterns.data.models


import com.google.gson.annotations.SerializedName

data class AddressModel(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: GeoModel,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
)


//get a string of ZipCode and City

fun AddressModel.getCityAndZipCode() = "$city, $zipcode"