package com.example.todoapp.controller

import com.example.todoapp.dto.user.UserCreateRequest
import com.example.todoapp.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/user")
    fun saveUser(@RequestBody request: UserCreateRequest) =
        userService.saveUser(request)
}