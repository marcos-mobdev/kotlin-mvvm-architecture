package br.com.appforge.kotlinmvvmarchitecture

class MyPost(){
    operator fun invoke():List<String>{
        return listOf(
            "Joçao", "Maria", "Jsodfo", "Mirailda"
        )
    }
}






fun main(){
    val post = MyPost()
    val list = post()
    print(list)
}