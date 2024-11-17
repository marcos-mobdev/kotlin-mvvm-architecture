package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.data.repository.UserRepository

class UserViewModelFactory (private val userRepository: UserRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            UserViewModel(userRepository) as T
        }else{
            throw IllegalArgumentException("ViewModel not configured correctly, expected ViewModel")
        }

    }
}