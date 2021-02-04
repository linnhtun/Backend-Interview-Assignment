package com.linnhtun.backendInterview.entity


final data class KeyCloakUser(
    var username: String? = null,
    var firstName: String? = null,
    var email: String? = null,
    var credentials: Array<KeyCloakCredential>? = null
) {
    var realmRoles: Array<String> = arrayOf<String>("app-user")

    var enabled: Boolean = true
}