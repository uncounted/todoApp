package com.example.todoapp.service

import com.example.todoapp.domain.user.User
import org.springframework.stereotype.Service

@Service
class CommonService(

) {
    // 시큐리티 도입 후 현재 로그인한 사용자로 변경해야 함
    fun getCurrentUser() = User.fixture()
}