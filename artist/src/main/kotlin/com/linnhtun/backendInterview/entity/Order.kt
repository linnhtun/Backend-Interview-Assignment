package com.linnhtun.backendInterview.entity

import javax.validation.constraints.*

final data class Order(@NotNull(message = "User ID is required") val userId: Long?, var dateTime: String?)