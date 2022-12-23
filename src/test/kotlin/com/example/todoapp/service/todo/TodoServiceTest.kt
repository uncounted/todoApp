package com.example.todoapp.service.todo

import com.example.todoapp.domain.todo.Todo
import com.example.todoapp.dto.todo.TodoCreateRequest
import com.example.todoapp.repository.TodoRepository
import com.example.todoapp.service.TodoService
import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
class TodoServiceTest @Autowired constructor(
    private val todoService: TodoService,
    private val todoRepository: TodoRepository
) {

    @AfterEach
    fun clear() {
        todoRepository.deleteAll()
    }

    @Test
    @DisplayName("todo 저장 성공")
    fun saveTodoTest() {
        // given
        val str = "테스트 작성하기"
        val request = TodoCreateRequest(
            content = str
        )

        // when
        val result = todoService.saveTodo(request)

        // then
        assertThat(result.content).isEqualTo(str)
        assertThat(result.isCompleted).isFalse
    }

    @Test
    @DisplayName("todo 전체 조회")
    fun getAllTodoTest() {
        // given
        todoRepository.saveAll(
            listOf(
                Todo.fixture(content = "1"),
                Todo.fixture(content = "2"),
                Todo.fixture(content = "3")
            ))

        // when
        val results = todoService.getAllTodos()

        // then
        assertThat(results).hasSize(3)
        assertThat(results[0].content).isEqualTo("1")
    }

    @Test
    @DisplayName("todo 1개 조회")
    fun getTodoTest() {
        // given
        val given = todoRepository.save(Todo.fixture(content = "todo 1개"))

        // when
        val results = todoRepository.findAll()

        // then
        assertThat(results[0].id).isEqualTo(
            given.id?.let { it }
        )
    }
}