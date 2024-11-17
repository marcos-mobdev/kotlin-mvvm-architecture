package br.com.appforge.kotlinmvvmarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private var count = 0

    //Observable liveData
    private val liveData = MutableLiveData<Int>()

    fun getLiveData(): MutableLiveData<Int> {
        liveData.value = count
        return liveData
    }

    fun increment(){
        count++
        liveData.value = count
    }

}