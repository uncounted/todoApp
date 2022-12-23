package com.example.todoapp.repository

import com.example.todoapp.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByUsername(username: String): User?
}