package br.com.appforge.kotlinmvvmarchitecture.data.repository

import br.com.appforge.kotlinmvvmarchitecture.data.api.JsonPlaceAPI
import br.com.appforge.kotlinmvvmarchitecture.data.model.toPost
import br.com.appforge.kotlinmvvmarchitecture.domain.model.Post

class PostRepository (
    private val jsonPlaceAPI: JsonPlaceAPI
):IPostRepository{
    //Access to the DB, and validates if the object is sucessfully returned

    override suspend fun getPosts():List<Post>{
        try{
            val response = jsonPlaceAPI.getPosts()
            if(response.isSuccessful && response.body() != null){
                val postListResponse = response.body()
                val postList = postListResponse?.map { postResponse->
                    postResponse.toPost()
                }
                if(postList != null){
                    return postList
                }
            }

        }catch(getPostError:Exception){
            getPostError.printStackTrace()
        }
        return emptyList()
    }
}