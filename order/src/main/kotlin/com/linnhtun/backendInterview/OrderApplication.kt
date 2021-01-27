package com.linnhtun.backendInterview

import com.linnhtun.backendInterview.configuration.ArtistProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("com.linnhtun.backendInterview.configuration.ArtistProperties")
class OrderApplication

fun main(args: Array<String>) {
    runApplication<OrderApplication>(*args)
}
