package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.appforge.kotlinmvvmarchitecture.data.repository.PostRepository
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository)
    :ViewModel(

){

    var postList = MutableLiveData< List<Post> >()
        get() = postRepository.postsList

    fun getPosts(){
        viewModelScope.launch {
            postRepository.getPosts()
        }
    }
}