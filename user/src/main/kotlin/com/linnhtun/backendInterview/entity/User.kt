package com.linnhtun.backendInterview.entity

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.*
import javax.persistence.*

@Entity(name = "users")
final data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {
    @NotNull(message = "Name is required")
    @Column(name = "name")
    val name: String? = null

    @NotNull(message = "Email is required")
    @Column(name = "email", unique = true)
    val email: String? = null

    @NotNull(message = "Password is required")
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null
}