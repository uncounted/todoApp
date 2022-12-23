package com.example.todoapp.repository

import com.example.todoapp.domain.todo.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

}