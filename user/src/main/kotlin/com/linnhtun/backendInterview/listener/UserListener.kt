package com.linnhtun.backendInterview.listener

import com.linnhtun.backendInterview.configuration.UserProperties
import com.linnhtun.backendInterview.entity.User
import com.linnhtun.backendInterview.response.TokenResponse
import com.linnhtun.backendInterview.response.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import javax.persistence.PostLoad
import javax.persistence.PostPersist
import javax.persistence.PostUpdate


class UserListener {
    @Autowired
    val userProperties: UserProperties? = null

    @PostPersist
    @PostUpdate
    @PostLoad
    fun afterSaved(user: User) {
        val tokenHeaders = HttpHeaders()
        tokenHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        val map: MultiValueMap<String, String> = LinkedMultiValueMap()
        map.add("grant_type", "client_credentials")
        map.add("client_id", userProperties?.keycloakClientId)
        map.add("client_secret", userProperties?.keycloakSecret)

        val tokenRequest = HttpEntity(map, tokenHeaders)
        val tokenResponse: ResponseEntity<TokenResponse>? = userProperties?.keycloakTokenUri?.let {
            RestTemplate().exchange(
                it,
                HttpMethod.POST,
                tokenRequest,
                TokenResponse::class.java
            )
        }

        val userHeaders = HttpHeaders()
        userHeaders.setContentType(MediaType.APPLICATION_JSON)
        tokenResponse?.body?.access_token?.let { userHeaders.setBearerAuth(it) }
        val userRequest = HttpEntity<User>(user, userHeaders)
        if (tokenResponse?.body?.access_token != null) {
            userProperties?.keycloakUserUri?.let {
                RestTemplate().exchange(
                    it,
                    HttpMethod.POST,
                    userRequest,
                    UserResponse::class.java
                )
            }
        }
    }
}