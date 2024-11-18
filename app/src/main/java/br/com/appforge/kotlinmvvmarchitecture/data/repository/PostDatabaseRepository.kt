package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post

class PostDatabaseRepository:IPostRepository {
    override val postsList = MutableLiveData<List<Post>>()


    override suspend fun getPosts() {
        val list =  listOf(
            Post("Body 1", 1, "Title 1", 1),
            Post("Body 2", 2, "Title 2", 2),
            Post("Body 3", 3, "Title 3", 3),
            Post("Body 4", 4, "Title 4", 4),
        )
        postsList.value = list
    }
}