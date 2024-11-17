package br.com.appforge.kotlinmvvmarchitecture.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.R
import br.com.appforge.kotlinmvvmarchitecture.databinding.ActivityFeedBinding
import br.com.appforge.kotlinmvvmarchitecture.viewModel.UserViewModel

class FeedActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityFeedBinding.inflate(layoutInflater)
    }

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        //Observer
        userViewModel.usersLiveData.observe(this){ users->
            Log.i("users_info", "observable running")
            var result = ""
            users.forEach{ user->
                result += "${user.name} - ${user.age}\n"

            }

            binding.textView.text = result

            Log.i("info_users", result)

        }

        binding.button.setOnClickListener {
            userViewModel.getUsers()
        }

        binding.btnNavigateMain.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}