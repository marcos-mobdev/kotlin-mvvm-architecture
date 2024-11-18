package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post

class PostFirebaseRepository() :IPostRepository{

    override val postsList = MutableLiveData<List<Post>>()


    //Simulating getting data from Firebase instead of API
    override suspend fun getPosts() {
        val list =  listOf(
            Post("Body", 10, "To Be", 123),
            Post("Body 2", 12, "Title", 112),
        )
        postsList.value = list
    }
}