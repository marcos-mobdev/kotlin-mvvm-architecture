package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.api.JsonPlaceAPI
import br.com.appforge.kotlinmvvmarchitecture.data.api.RetrofitService
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post

class PostRepository (
    private val jsonPlaceAPI: JsonPlaceAPI
):IPostRepository{

    override val postsList = MutableLiveData<List<Post>>()

    override suspend fun getPosts(){

        try{
            val response = jsonPlaceAPI.getPosts()
            if(response.isSuccessful && response.body() != null){
                postsList.postValue(response.body())
            }

        }catch(getPostError:Exception){
            getPostError.printStackTrace()
        }

    }
}