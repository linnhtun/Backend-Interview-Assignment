package com.linnhtun.backendInterview.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "artist")
class ArtistProperties {
    var boughtArtUri: String = ""
}