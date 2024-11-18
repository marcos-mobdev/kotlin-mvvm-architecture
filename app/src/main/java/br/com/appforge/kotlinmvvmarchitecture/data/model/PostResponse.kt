package br.com.appforge.kotlinmvvmarchitecture.data.model

import br.com.appforge.kotlinmvvmarchitecture.domain.model.Post

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)

fun PostResponse.toPost():Post{
    return Post(
        text = this.body,
        title = this.title,
        id = this.id,
        userId = this.userId
    )
}