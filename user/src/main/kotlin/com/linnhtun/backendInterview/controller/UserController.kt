package com.linnhtun.backendInterview.controller

import com.linnhtun.backendInterview.configuration.UserProperties
import com.linnhtun.backendInterview.entity.KeyCloakCredential
import com.linnhtun.backendInterview.entity.KeyCloakUser
import com.linnhtun.backendInterview.entity.User
import com.linnhtun.backendInterview.exception.DuplicateEmailException
import com.linnhtun.backendInterview.repository.UserRepository
import com.linnhtun.backendInterview.response.TokenResponse
import com.linnhtun.backendInterview.response.UserResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import kotlin.collections.MutableIterable
import java.util.Optional
import javax.validation.Valid
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

@RestController
@Validated
class UserController {
    @Autowired
    private val userRepository: UserRepository? = null

    @Autowired
    val userProperties: UserProperties? = null

    @GetMapping("/users")
    fun getAll(): MutableIterable<User>? {
        return userRepository?.findAll()
    }

    @PostMapping("/users/register")
    fun register(@Valid @RequestBody user: User): User? {
        if (user.email?.let { userRepository?.existsByEmail(it) } == true) {
            throw DuplicateEmailException()
        }
        val userPassword = user.password
        user.password = BCryptPasswordEncoder().encode(user.password)
        val res: User? = userRepository?.save(user)

        try {
            if (res != null) {
                createKeyCloakUser(
                    KeyCloakUser(
                        user.email,
                        user.name,
                        user.email,
                        arrayOf<KeyCloakCredential>(KeyCloakCredential("password", userPassword))
                    )
                )
            }
        } catch (e: Exception) {
        }
        return res
    }

    @GetMapping("/users/me")
    fun get(): Optional<User>? {
        return userRepository?.findById(1)
    }

    fun createKeyCloakUser(user: KeyCloakUser) {
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
        val userRequest = HttpEntity<KeyCloakUser>(user, userHeaders)
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