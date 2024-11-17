package br.com.appforge.kotlinmvvmarchitecture.model

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)