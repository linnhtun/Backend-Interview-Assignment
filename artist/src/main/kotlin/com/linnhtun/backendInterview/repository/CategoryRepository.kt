package com.linnhtun.backendInterview.repository

import org.springframework.data.repository.CrudRepository
import com.linnhtun.backendInterview.entity.Category
import java.util.Optional

interface CategoryRepository : CrudRepository<Category, Long> {
    override fun findById(id: Long): Optional<Category>
}