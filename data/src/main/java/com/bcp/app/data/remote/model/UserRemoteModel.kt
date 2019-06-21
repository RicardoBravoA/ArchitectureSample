package com.bcp.app.data.remote.model

import com.google.gson.annotations.SerializedName

data class UserRemoteModel(
    @SerializedName("id") var id: String,
    @SerializedName("login") var login: String,
    @SerializedName("avatar_url") var avatarUrl: String,
    @SerializedName("name") var name: String,
    @SerializedName("company") var company: String,
    @SerializedName("blog") var blog: String
)