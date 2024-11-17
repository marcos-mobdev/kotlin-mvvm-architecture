package br.com.appforge.kotlinmvvmarchitecture.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appforge.kotlinmvvmarchitecture.model.User
import br.com.appforge.kotlinmvvmarchitecture.model.api.UserApi

class UserViewModel :ViewModel(){

    private val userApi = UserApi()
    val usersLiveData = MutableLiveData< List<User> >()


    fun getUsers(){
        val list = userApi.getUsers()
        Log.i("info_users", "getUsers: $list")
        usersLiveData.value = list
    }
}