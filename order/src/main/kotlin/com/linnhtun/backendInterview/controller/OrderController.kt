package com.linnhtun.backendInterview.controller

import com.linnhtun.backendInterview.entity.Order
import com.linnhtun.backendInterview.entity.OrderItem
import com.linnhtun.backendInterview.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import kotlin.collections.MutableIterable
import java.util.Optional
import javax.validation.Valid;

@RestController
@Validated
class OrderController {
    @Autowired
    private val orderRepository: OrderRepository? = null

    @GetMapping("/orders")
    fun getAll(): MutableIterable<Order>? {
        return orderRepository?.findAll();
    }

    @PostMapping("/orders")
    fun createOrder(@Valid @RequestBody order: Order): Order? {
        for (item: OrderItem in order.items!!) {
            item.order = order;
        }
        return orderRepository?.save(order);
    }

    @GetMapping("/orders/{id}")
    fun get(@PathVariable("id") id: Long): Optional<Order>? {
        return orderRepository?.findById(id)
    }
}