package com.example.todoapp.controller

import com.example.todoapp.dto.todo.TodoCreateRequest
import com.example.todoapp.dto.todo.TodoResponse
import com.example.todoapp.dto.todo.TodoUpdateContentRequest
import com.example.todoapp.dto.todo.TodoUpdateIsCompletedRequest
import com.example.todoapp.service.TodoService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController (
    private val todoService: TodoService
) {
    // 한 개 생성
    @PostMapping("/todo")
    fun saveTodo(@RequestBody request: TodoCreateRequest) =
        todoService.saveTodo(request)

    // 전체 조회
    @GetMapping("/todo")
    fun getAllTodos(): List<TodoResponse> =
        todoService.getAllTodos()

    // 한 개 조회
    @GetMapping("/todo/{id}")
    fun getTodo(@PathVariable id: Long) =
        todoService.getTodo(id)

    // 컨텐츠 변경
    @PostMapping("/todo/update/content/{id}")
    fun updateTodoContent(@PathVariable id: Long, @RequestBody request: TodoUpdateContentRequest): TodoResponse =
        todoService.updateTodoContent(id, request)

    // 완료/미완료 변경
    @PostMapping("/todo/update/isCompleted/{id}")
    fun updateTodoIsCompleted(@PathVariable id: Long, @RequestBody request: TodoUpdateIsCompletedRequest): TodoResponse =
        todoService.updateTodoIsCompleted(id, request)

    // 삭제
    @DeleteMapping("/todo/{id}")
    fun deleteTodo(@PathVariable id: Long){
        todoService.deleteTodo(id)
    }


}