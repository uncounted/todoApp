package com.example.todoapp.dto.todo

import java.time.LocalDateTime

data class TodoUpdateContentRequest (
    val content: String
)

data class TodoUpdateIsCompletedRequest (
    val isCompleted: Boolean
)

data class TodoUpdateDueDateRequest (
    val dueDate: LocalDateTime
)