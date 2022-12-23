package com.example.todoapp.domain.user

import com.example.todoapp.domain.BaseTimeEntity
import com.example.todoapp.domain.todo.Todo
import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class User(

    val username: String,

    private var name: String,

    private var password: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonBackReference
    val todoList: MutableList<Todo> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseTimeEntity() {

    fun updateName(name: String) {
        this.name = name
    }

    fun updatePassword(password: String) {
        this.password = password
    }

    // 테스트용 데이터
    companion object {
        fun fixture(
            username: String = "userA",
            name: String = "A",
            password: String = "asdf",
        ): User {
            return User(
                username = username,
                name = name,
                password = password)
        }
    }
}