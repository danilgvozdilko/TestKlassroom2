package com.game.testklassroom2.data.model

import com.google.gson.annotations.SerializedName

data class PostDto(
    val date: String?,
    val id: Long?,
    val message: String?,
    val photo: String?,
    @SerializedName("user_id")
    val userId: String?,
    @SerializedName("user_name")
    val userName: String?,
    @SerializedName("user_pic")
    val userPic: String?
)