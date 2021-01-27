package com.linnhtun.backendInterview.listener

import com.linnhtun.backendInterview.configuration.ArtistProperties
import com.linnhtun.backendInterview.entity.Order
import com.linnhtun.backendInterview.entity.OrderItem
import com.linnhtun.backendInterview.response.ArtistResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import javax.persistence.PostLoad
import javax.persistence.PostPersist
import javax.persistence.PostUpdate
import java.util.HashMap


class OrderItemListener {

    @Autowired
    val artistProperties: ArtistProperties? = null

    @PostPersist
    @PostUpdate
    @PostLoad
    fun afterSaved(orderItem: OrderItem) {
        val headers = HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON);
        val request = HttpEntity<Order>(orderItem.order, headers);
        val boughtArtUri = orderItem?.artId?.let { artistProperties?.boughtArtUri?.replace(":artId", it) }

        if (boughtArtUri !== null) {
            val response: ResponseEntity<ArtistResponse>? =
                RestTemplate().exchange(
                    boughtArtUri,
                    HttpMethod.POST,
                    request,
                    ArtistResponse::class.java
                )
        }
    }
}