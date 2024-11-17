package br.com.appforge.kotlinmvvmarchitecture.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinmvvmarchitecture.model.api.PostAPI
import br.com.appforge.kotlinmvvmarchitecture.model.Post
import kotlinx.coroutines.launch

class PostViewModel :ViewModel(

){

    val postList = MutableLiveData< List<Post> >()

    fun getPosts(){
        val postAPI = PostAPI()
        viewModelScope.launch {
            val posts = postAPI.getPosts()
            postList.postValue(posts)
        }
    }
}