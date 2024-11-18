package br.com.appforge.kotlinmvvmarchitecture.presentation.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.appforge.kotlinmvvmarchitecture.data.api.RetrofitService
import br.com.appforge.kotlinmvvmarchitecture.data.repository.PostRepository
import br.com.appforge.kotlinmvvmarchitecture.databinding.ActivityPostsBinding
import br.com.appforge.kotlinmvvmarchitecture.domain.usecase.PostUseCase
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

        //Alternatives for repository after Clean Architecture
        val jsonPlaceAPI = RetrofitService.getJsonPlace()
        val postRepository = PostRepository(jsonPlaceAPI)
        val postUseCase = PostUseCase(postRepository)




        //Provider will auto-instance the View Model
        //postViewModel = ViewModelProvider(this)[PostViewModel::class.java]
        postViewModel = ViewModelProvider(
            this,
            PostViewModelFactory(postUseCase)
        )[PostViewModel::class.java]

        //Observe for alterations at postList
        postViewModel.postResponseList.observe(this){ postList->
            var listText = ""
            postList.forEach{ post->
                listText += "${post.id}) - ${post.text}\n"
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