package br.com.appforge.kotlinmvvmarchitecture.data.api

import br.com.appforge.kotlinmvvmarchitecture.data.model.User

class UserApi {

    fun getUsers(): List<User> {
        val userList = listOf(
            User("Marcos", 23),
            User("Natan", 24),
            User("Falcão", 25),
            User("Pedro", 33),
            User("João", 12)
        )
        return  userList
    }
}