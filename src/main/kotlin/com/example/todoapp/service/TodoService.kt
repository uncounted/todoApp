package com.example.todoapp.service

import com.example.todoapp.domain.todo.Todo
import com.example.todoapp.domain.user.User
import com.example.todoapp.dto.todo.TodoCreateRequest
import com.example.todoapp.dto.todo.TodoResponse
import com.example.todoapp.dto.todo.TodoUpdateContentRequest
import com.example.todoapp.dto.todo.TodoUpdateIsCompletedRequest
import com.example.todoapp.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TodoService (
    private val todoRepository: TodoRepository,
    private val commonService: CommonService
) {

    @Transactional
    fun saveTodo(request: TodoCreateRequest) =
        todoRepository.save(
            Todo(content = request.content,
                isCompleted = false,
                dueDate = null,
                user = commonService.getCurrentUser(),
                id = null)
        )

    @Transactional(readOnly = true)
    fun getAllTodos() =
        todoRepository.findAll().map(Todo::toResponse)

    @Transactional(readOnly = true)
    fun getTodo(id: Long) =
        findTodoById(id)

    @Transactional
    fun updateTodoContent(todoId: Long, request: TodoUpdateContentRequest): TodoResponse {
        val todo = findTodoById(todoId)
        todo.updateContent(request.content)
        return todo.toResponse()
    }

    @Transactional
    fun updateTodoIsCompleted(todoId: Long, request: TodoUpdateIsCompletedRequest): TodoResponse {
        val todo = findTodoById(todoId)
        todo.updateIsCompleted(request.isCompleted)
        return todo.toResponse()
    }

    @Transactional
    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)

    // 공통 메소드
    fun findTodoById(id: Long): Todo =
        todoRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("아이디 $id 에 해당하는 todo가 없습니다.") // Optional 을 사용하지 않고 null로 처리하는 법
        //todoRepository.findById(id).orElseThrow{ throw IllegalArgumentException("아이디 $id 에 해당하는 todo가 없습니다.") }
}