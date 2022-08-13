package com.sebqv97.differentdesignpatterns.data.models


import com.google.gson.annotations.SerializedName

data class CompanyModel(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
)

fun CompanyModel.getCompanyName() = name