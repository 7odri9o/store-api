package br.com.studies.storeapi.web.converters

import br.com.studies.storeapi.commons.EMPTY_OR_NULL_EMAIL_MESSAGE
import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.web.controllers.dto.UserDTO

fun UserDTO.convert(): User {
    if (this.email.isNullOrBlank()) throw IllegalArgumentException(EMPTY_OR_NULL_EMAIL_MESSAGE)
    return User(
        email = this.email
    )
}

fun User.revert(): UserDTO {
    return UserDTO(
        email = this.email
    )
}