package br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appforge.kotlinmvvmarchitecture.data.model.User
import br.com.appforge.kotlinmvvmarchitecture.data.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) :ViewModel(){

    var usersLiveData = MutableLiveData< List<User> >()
        get() = userRepository.userList


    fun getUsers(){
        userRepository.getUsers()
    }
}