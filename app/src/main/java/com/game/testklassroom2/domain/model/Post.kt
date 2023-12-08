package com.game.testklassroom2.domain.model

import java.util.Date

class Post(
    val date: Date?,
    val id: Long,
    val message: String,
    val photo: String,
    val userId: String,
    val userName: String,
    val userPic: String
)