package com.linnhtun.backendInterview.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.OneToMany
import kotlin.collections.Set
import javax.persistence.*

@Entity(name = "artists")
final data class Artist(val name: String?, val bio: String?) {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    var arts: Set<Art>? = null
}