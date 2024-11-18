package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.model.PostResponse
import br.com.appforge.kotlinmvvmarchitecture.domain.model.Post

interface IPostRepository {
    suspend fun getPosts():List<Post>
}