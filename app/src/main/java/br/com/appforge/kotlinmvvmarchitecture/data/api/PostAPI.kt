package br.com.appforge.kotlinmvvmarchitecture.data.api

import br.com.appforge.kotlinmvvmarchitecture.data.api.RetrofitService
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post

class PostAPI {

    suspend fun getPosts():List<Post>{
        val jsonPlace = RetrofitService.getJsonPlace()

        try{
            val response = jsonPlace.getPosts()
            if(response.isSuccessful){
                response.body()?.let { posts ->
                    return posts
                }
            }

        }catch(getPostError:Exception){
            getPostError.printStackTrace()
        }

        return emptyList()
    }
}