package br.com.appforge.kotlinmvvmarchitecture.api

import br.com.appforge.kotlinmvvmarchitecture.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {

    @GET("posts")
    suspend fun getPosts() : Response <List<Post>>
}