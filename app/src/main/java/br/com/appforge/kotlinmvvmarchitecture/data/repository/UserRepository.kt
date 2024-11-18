package br.com.appforge.kotlinmvvmarchitecture.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.appforge.kotlinmvvmarchitecture.data.model.User

class UserRepository{

    var userList = MutableLiveData<List<User>>()

    fun getUsers() {
        userList.postValue(listOf(
            User("Marcos", 23),
            User("Natan", 24),
            User("Falcão", 25),
            User("Pedro", 33),
            User("João", 12)
        ))
    }
}