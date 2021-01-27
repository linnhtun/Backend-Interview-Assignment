package com.linnhtun.backendInterview.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import kotlin.collections.Set

@Entity(name = "categories")
final data class Category(val name: String?) {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "art_category",
        joinColumns = [JoinColumn(name = "category_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "art_id", referencedColumnName = "id")]
    )
    @JsonIgnore
    var arts: Set<Art>? = null
}