package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.domain.usecase.PostUseCase

class PostViewModelFactory(
    private val postUseCase:PostUseCase
) :ViewModelProvider.Factory{
    //Creates a constructor for custom ViewModel, that will be used at ViewModelProvider

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            PostViewModel(postUseCase) as T
        }else{
            throw IllegalArgumentException("ViewModel not configured correctly, expected ViewModel")
        }
    }

}