package com.example.todoapp.service

import com.example.todoapp.domain.user.User
import com.example.todoapp.dto.user.UserCreateRequest
import com.example.todoapp.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun saveUser(request: UserCreateRequest): User =
        userRepository.save(User(
            name = request.name,
            username = request.username,
            password = request.password
        ))


}