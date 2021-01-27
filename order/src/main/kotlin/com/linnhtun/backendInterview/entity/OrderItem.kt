package com.linnhtun.backendInterview.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.linnhtun.backendInterview.listener.OrderItemListener
import javax.persistence.*

@Entity(name = "order_items")
@EntityListeners(OrderItemListener::class)
final data class OrderItem(
    @Column(name = "art_id") val artId: String?,
    @Column(name = "art_name") val artName: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JsonIgnore
    var order: Order? = null
}