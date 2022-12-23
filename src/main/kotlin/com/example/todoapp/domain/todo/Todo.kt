package com.example.todoapp.domain.todo

import com.example.todoapp.domain.BaseTimeEntity
import com.example.todoapp.domain.user.User
import com.example.todoapp.dto.todo.TodoResponse
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Todo(
    var content: String,

    var isCompleted: Boolean,

    var dueDate: LocalDateTime?,

    @ManyToOne(cascade = [CascadeType.ALL])
    val user: User,

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id: Long? = null
) : BaseTimeEntity() {

    fun updateContent(content: String) {
        this.content = content
    }

    fun updateIsCompleted(isCompleted: Boolean) {
        this.isCompleted = isCompleted
    }

    fun toResponse(): TodoResponse = TodoResponse(
        this.id!!,
        this.content,
        this.isCompleted,
        this.dueDate,
        this.createdDate,
        this.modifiedDate,
        this.user
    )

    // 테스트용 데이터
    companion object {
        fun fixture(
            content: String = "할 일",
            isCompleted: Boolean = false,
            dueDate: LocalDateTime = LocalDateTime.now().plusDays(1),
            user: User = User.fixture(),
            id: Long? = null
        ): Todo {
            return Todo(
                content = content,
                isCompleted = isCompleted,
                dueDate = dueDate,
                user = user,
                id = id
            )
        }
    }
}