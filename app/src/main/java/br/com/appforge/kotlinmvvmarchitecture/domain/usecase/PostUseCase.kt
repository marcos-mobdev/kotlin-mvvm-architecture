package br.com.appforge.kotlinmvvmarchitecture.domain.usecase

import br.com.appforge.kotlinmvvmarchitecture.data.model.PostResponse
import br.com.appforge.kotlinmvvmarchitecture.data.repository.IPostRepository
import br.com.appforge.kotlinmvvmarchitecture.domain.model.Post

class PostUseCase(
    private val repository: IPostRepository
) {
    //call methods for getting data, and business rules for the application

    /*
    suspend fun getPosts():List<Post>{
        try{
            return repository.getPosts()
        }catch(errorGettingPosts:Exception){
            errorGettingPosts.printStackTrace()
        }
        return emptyList()
    }
     */

    suspend operator fun invoke():List<Post>{
        try{
            return repository.getPosts()
        }catch(errorGettingPosts:Exception){
            errorGettingPosts.printStackTrace()
        }
        return emptyList()
    }

}