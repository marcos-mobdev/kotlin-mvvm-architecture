package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinmvvmarchitecture.domain.model.Post
import br.com.appforge.kotlinmvvmarchitecture.domain.usecase.PostUseCase
import kotlinx.coroutines.launch

class PostViewModel(private val postUseCase: PostUseCase)
    :ViewModel(){
    //Calls the methods for getting data into the coroutine, and update data to LiveData


    var postResponseList = MutableLiveData< List<Post> >()
        //get() = repository.postsList

    fun getPosts(){
        viewModelScope.launch {
            val postsList = postUseCase()
            postResponseList.postValue(postsList)
        }
    }
}