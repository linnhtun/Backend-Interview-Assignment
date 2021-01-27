package com.linnhtun.backendInterview.repository

import org.springframework.data.repository.CrudRepository
import com.linnhtun.backendInterview.entity.Art
import java.util.Optional

interface ArtRepository : CrudRepository<Art, Long> {
    override fun findById(id: Long): Optional<Art>
}