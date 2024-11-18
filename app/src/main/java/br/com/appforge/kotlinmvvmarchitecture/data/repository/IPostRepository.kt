package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post

interface IPostRepository {
    val postsList : MutableLiveData<List<Post>>

   suspend fun getPosts()
}