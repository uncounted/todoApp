package com.example.todoapp.dto.todo

import com.example.todoapp.domain.user.User
import java.time.LocalDateTime

data class TodoResponse (
    val id: Long,
    val content: String,
    val isCompleted: Boolean,
    val dueDate: LocalDateTime?,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    val user: User
)