package com.game.testklassroom2.ui.mapping

import com.game.testklassroom2.domain.model.Post
import com.game.testklassroom2.ui.model.PostItemModel
import java.text.SimpleDateFormat
import java.util.Locale

fun Post.toItemModel(): PostItemModel {
    val outputFormat = SimpleDateFormat("E dd, yyyy h:mm a", Locale.ENGLISH)
    return PostItemModel(
        date = date?.let { outputFormat.format(it) } ?: "",
        id = id,
        message = message,
        photo = photo,
        userId = userId,
        userName = userName,
        userPic = userPic
    )
}
