package com.linnhtun.backendInterview.repository

import org.springframework.data.repository.CrudRepository
import com.linnhtun.backendInterview.entity.Artist
import java.util.Optional

interface ArtistRepository : CrudRepository<Artist, Long> {
    override fun findById(id: Long): Optional<Artist>
}