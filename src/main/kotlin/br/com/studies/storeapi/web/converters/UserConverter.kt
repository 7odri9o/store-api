package br.com.studies.storeapi.web.converters

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.web.controllers.dto.UserDTO

fun UserDTO.convert(): User {
    if (this.email.isNullOrBlank()) throw IllegalArgumentException("Email cannot be empty or null")
    return User(
        email = this.email
    )
}

fun User.revert(): UserDTO {
    return UserDTO(
        email = this.email
    )
}