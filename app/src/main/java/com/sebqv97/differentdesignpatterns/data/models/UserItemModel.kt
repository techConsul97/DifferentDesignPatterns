package com.sebqv97.differentdesignpatterns.data.models


import com.google.gson.annotations.SerializedName

data class UserItemModel(
    @SerializedName("address")
    val address: AddressModel,
    @SerializedName("company")
    val company: CompanyModel,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)

