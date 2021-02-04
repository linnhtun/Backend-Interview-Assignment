package com.linnhtun.backendInterview

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ConfigurationPropertiesScan("com.linnhtun.backendInterview.configuration.UserProperties")
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
