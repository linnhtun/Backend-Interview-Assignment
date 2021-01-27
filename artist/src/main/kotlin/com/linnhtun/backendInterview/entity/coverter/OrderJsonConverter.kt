package com.linnhtun.backendInterview.entity.coverter

import javax.persistence.AttributeConverter
import javax.persistence.Converter
import java.io.IOException

import com.fasterxml.jackson.core.JsonProcessingException

import com.fasterxml.jackson.databind.ObjectMapper
import com.linnhtun.backendInterview.entity.Order
import org.springframework.beans.factory.annotation.Autowired


@Converter(autoApply = true)
class OrderJsonConverter : AttributeConverter<Order, String> {

    @Autowired
    val objectMapper: ObjectMapper? = null

    override fun convertToDatabaseColumn(attribute: Order?): String? {
        return try {
            this.objectMapper?.writeValueAsString(attribute)
        } catch (ex: JsonProcessingException) {
            null
        }
    }

    override fun convertToEntityAttribute(dbData: String?): Order? {
        return try {
            this.objectMapper?.readValue(dbData, Order::class.java)
        } catch (ex: IOException) {
            null
        }
    }
}