package br.com.appforge.kotlinmvvmarchitecture.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.R
import br.com.appforge.kotlinmvvmarchitecture.data.api.RetrofitService
import br.com.appforge.kotlinmvvmarchitecture.databinding.ActivityPostsBinding
import br.com.appforge.kotlinmvvmarchitecture.data.model.Post
import br.com.appforge.kotlinmvvmarchitecture.data.repository.PostRepository
import br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel.MainViewModel
import br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel.PostViewModel
import br.com.appforge.kotlinmvvmarchitecture.presentation.viewModel.PostViewModelFactory

class PostsActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityPostsBinding.inflate(layoutInflater)
    }

    lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val jsonPlaceAPI = RetrofitService.getJsonPlace()
        val postRepository = PostRepository(jsonPlaceAPI)

        //Provider will auto-instance the View Model
        //postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel = ViewModelProvider(
            this,
            PostViewModelFactory(postRepository)
        )[PostViewModel::class.java]

        //Observe for alterations at postList
        postViewModel.postList.observe(this){ postList->
            var listText = ""
            postList.forEach{ post->
                listText += "${post.id}) - ${post.body}\n"
            }
            binding.textView.text = listText
        }

        binding.btnNavigate.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }

        binding.btnGetPosts.setOnClickListener {
            postViewModel.getPosts()
        }

    }

    /*
    override fun onStart() {
        super.onStart()
        postViewModel.getPosts()
    }

     */


}