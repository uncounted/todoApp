package com.example.todoapp.dto.user

data class UserCreateRequest(
    val username: String,
    val password: String,
    val name: String,
    var id: Long? = null
)