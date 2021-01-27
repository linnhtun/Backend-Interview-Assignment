package com.linnhtun.backendInterview.controller

import com.linnhtun.backendInterview.entity.Category
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import com.linnhtun.backendInterview.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import kotlin.collections.MutableIterable
import org.springframework.web.bind.annotation.PathVariable
import java.util.Optional

@RestController
class CategoryController {
    @Autowired
    private val categoryRepository: CategoryRepository? = null

    @GetMapping("/categories")
    fun getAll(): MutableIterable<Category>? {
        return categoryRepository?.findAll();
    }

    @GetMapping("/categories/{id}")
    fun get(@PathVariable("id") id: Long): Optional<Category>? {
        return categoryRepository?.findById(id)
    }
}