package br.com.appforge.kotlinmvvmarchitecture.presentation.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.appforge.kotlinmvvmarchitecture.R
import br.com.appforge.kotlinmvvmarchitecture.databinding.ActivityMainBinding
import br.com.appforge.kotlinmvvmarchitecture.data.model.User


class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }



    private lateinit var dataBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //DataBinding
        dataBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        //Data
        val user = User("Marcos", 23)
        dataBinding.user = user
        dataBinding.click = ClickEvent(this)




    }
    inner class ClickEvent(private val context: Context){

        fun executeAction(view: View){
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
        }



    }
}