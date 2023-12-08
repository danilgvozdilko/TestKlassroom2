package com.game.testklassroom2.data.mapping

import com.game.testklassroom2.data.model.PostDto
import com.game.testklassroom2.domain.model.Post
import java.text.SimpleDateFormat
import java.util.Locale

fun PostDto.toDomain(): Post? {
    return try {
        val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH)
        val dates = date?.let { inputFormat.parse(it) }
        Post(
            date = dates,
            message = message ?: "",
            photo = photo ?: "",
            userId = userId ?: "",
            userName = userName ?: "",
            userPic = userPic ?: "",
            id = requireNotNull(this.id)
        )
    } catch (ex: Exception) {
        null
    }
}
