package com.linnhtun.backendInterview.controller

import com.fasterxml.jackson.databind.JsonNode
import com.linnhtun.backendInterview.entity.Art
import com.linnhtun.backendInterview.entity.Order
import com.linnhtun.backendInterview.repository.ArtRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import kotlin.collections.MutableIterable
import java.util.Optional
import javax.validation.Valid

@RestController
@Validated
class ArtController {
    @Autowired
    private val artRepository: ArtRepository? = null

    @GetMapping("/arts")
    fun getAll(): MutableIterable<Art>? {
        return artRepository?.findAll();
    }

    @PostMapping("/arts/{id}/buy")
    fun buyArt(@PathVariable("id") id: Long, @Valid @RequestBody order: Order): Art? {
        val art: Art? = artRepository?.findById(id)?.orElse(null)
        if (art != null) {
            order.dateTime = LocalDateTime.now().toString()
            art.buyer = order
            art.status = "bought"
            return artRepository?.save(art)
        }
        return null
    }

    @GetMapping("/arts/{id}")
    fun get(@PathVariable("id") id: Long): Optional<Art>? {
        return artRepository?.findById(id)
    }
}