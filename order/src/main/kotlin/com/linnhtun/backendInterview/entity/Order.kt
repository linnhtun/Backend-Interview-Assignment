package com.linnhtun.backendInterview.entity

import javax.persistence.*
import javax.validation.constraints.*

@Entity(name = "orders")
final data class Order(@NotNull(message = "User ID is required") @Column(name = "user_id") val userId: Long?) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @NotNull(message = "Items are required")
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var items: Set<OrderItem>? = null
}