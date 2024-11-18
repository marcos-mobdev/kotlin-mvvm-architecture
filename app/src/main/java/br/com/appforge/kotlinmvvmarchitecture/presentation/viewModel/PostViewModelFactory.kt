package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.data.repository.IPostRepository
import br.com.appforge.kotlinmvvmarchitecture.data.repository.PostRepository

class PostViewModelFactory(
    private val repository: IPostRepository
) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            PostViewModel(repository) as T
        }else{
            throw IllegalArgumentException("ViewModel not configured correctly, expected ViewModel")
        }
    }

}