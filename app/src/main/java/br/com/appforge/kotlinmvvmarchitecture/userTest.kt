package br.com.appforge.kotlinmvvmarchitecture

import br.com.appforge.kotlinmvvmarchitecture.viewModel.UserViewModel

class userTest {

    fun runTest(){
        //Simulating testes with MVVM
        val userViewModel = UserViewModel()
        userViewModel.getUsers()
    }


}