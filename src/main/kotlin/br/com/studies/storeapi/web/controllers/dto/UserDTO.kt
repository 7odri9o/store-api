package br.com.studies.storeapi.web.controllers.dto

import br.com.studies.storeapi.domain.dto.User

data class UserDTO(
    val email: String? = null
)

fun UserDTO.convert(): User {
    if (this.email.isNullOrBlank()) throw IllegalArgumentException("Email cannot be null or empty")
    return User(email = this.email)
}