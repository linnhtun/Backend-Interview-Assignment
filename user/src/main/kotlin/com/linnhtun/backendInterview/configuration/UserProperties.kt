package com.linnhtun.backendInterview.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "user")
class UserProperties {
    var keycloakUserUri: String = ""
    var keycloakSecret: String = ""
    var keycloakTokenUri: String = ""
    var keycloakClientId: String = ""
}