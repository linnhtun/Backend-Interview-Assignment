package com.linnhtun.backendInterview.controller

import com.linnhtun.backendInterview.configuration.ArtistProperties
import com.linnhtun.backendInterview.entity.Order
import com.linnhtun.backendInterview.entity.OrderItem
import com.linnhtun.backendInterview.exception.ArtAlreadyBoughtException
import com.linnhtun.backendInterview.repository.OrderRepository
import com.linnhtun.backendInterview.response.ArtResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import kotlin.collections.MutableIterable
import java.util.Optional
import javax.validation.Valid;

@RestController
@Validated
class OrderController {
    @Autowired
    private val orderRepository: OrderRepository? = null

    @Autowired
    val artistProperties: ArtistProperties? = null

    @GetMapping("/orders")
    fun getAll(): MutableIterable<Order>? {
        return orderRepository?.findAll()
    }

    @PostMapping("/orders")
    fun createOrder(@Valid @RequestBody order: Order): Order? {
        System.out.println("asdasd")
        for (item: OrderItem in order.items!!) {
            item.order = order
            if (isArtAlreadyBought(item?.artId)) {
                throw ArtAlreadyBoughtException()
            }
        }
        return orderRepository?.save(order)
    }

    @GetMapping("/orders/{id}")
    fun get(@PathVariable("id") id: Long): Optional<Order>? {
        return orderRepository?.findById(id)
    }

    fun isArtAlreadyBought(artId: Long?): Boolean {
        val boughtCheckUri = artId?.let { artistProperties?.boughtCheckUri?.replace(":artId", it.toString()) }

        val response: ArtResponse? = boughtCheckUri?.let {
            RestTemplate().getForObject(
                it, ArtResponse::class.java
            )
        }

        return response?.buyer != null
    }
}