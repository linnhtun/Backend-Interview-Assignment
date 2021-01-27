package com.linnhtun.backendInterview.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.linnhtun.backendInterview.entity.coverter.OrderJsonConverter
import javax.persistence.*

@Entity(name = "arts")
final data class Art(val name: String?) {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "buyer", columnDefinition = "json")
    @Convert(converter = OrderJsonConverter::class)
    var buyer: Order? = null

    @Column(name = "status")
    var status: String? = null

    @ManyToOne()
    @JoinColumn(name = "artist_id")
    @JsonIgnore
    var artist: Artist? = null

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "art_category",
        joinColumns = [JoinColumn(name = "art_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "category_id", referencedColumnName = "id")]
    )
    var categories: Set<Category>? = null
}