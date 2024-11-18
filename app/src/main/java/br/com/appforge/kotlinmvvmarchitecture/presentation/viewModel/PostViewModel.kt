package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post
import br.com.appforge.kotlinmvvmarchitecture.data.repository.IPostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: IPostRepository)
    :ViewModel(

){

    var postList = MutableLiveData< List<Post> >()
        get() = repository.postsList

    fun getPosts(){
        viewModelScope.launch {
            repository.getPosts()
        }
    }
}