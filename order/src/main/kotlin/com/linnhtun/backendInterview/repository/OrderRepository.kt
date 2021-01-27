package com.linnhtun.backendInterview.repository

import org.springframework.data.repository.CrudRepository
import com.linnhtun.backendInterview.entity.Order
import java.util.Optional

interface OrderRepository : CrudRepository<Order, Long> {
    override fun findById(id: Long): Optional<Order>
}