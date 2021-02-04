package com.linnhtun.backendInterview.repository

import org.springframework.data.repository.CrudRepository
import com.linnhtun.backendInterview.entity.User
import java.util.Optional

interface UserRepository : CrudRepository<User, Long> {
    override fun findById(id: Long): Optional<User>
    fun existsByEmail(email: String): Boolean
}