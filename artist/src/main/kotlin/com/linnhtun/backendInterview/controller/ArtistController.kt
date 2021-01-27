package com.linnhtun.backendInterview.controller

import com.linnhtun.backendInterview.entity.Artist
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import com.linnhtun.backendInterview.repository.ArtistRepository
import org.springframework.beans.factory.annotation.Autowired
import kotlin.collections.MutableIterable
import org.springframework.web.bind.annotation.PathVariable
import java.util.Optional

@RestController
class ArtistController {
    @Autowired
    private val artistRepository: ArtistRepository? = null

    @GetMapping("/artists")
    fun getAll(): MutableIterable<Artist>? {
        return artistRepository?.findAll();
    }

    @GetMapping("/artists/{id}")
    fun get(@PathVariable("id") id: Long): Optional<Artist>? {
        return artistRepository?.findById(id)
    }
}