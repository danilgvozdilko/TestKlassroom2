package com.game.testklassroom2.ui.model

data class PostItemModel(
    val date: String,
    val id: Long,
    val message: String,
    val photo: String,
    val userId: String,
    val userName: String,
    val userPic: String
)