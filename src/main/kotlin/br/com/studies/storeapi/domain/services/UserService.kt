package br.com.studies.storeapi.domain.services

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.web.controllers.dto.Response
import java.util.*

interface UserService {

    fun isAlreadyUser(email: String): Pair<Int, Response>
    fun create(user: User): Pair<Int, Response>
    fun findById(id: UUID, token: String): Pair<Int, Response>
    fun findByEmail(email: String): Pair<Int, Response>
    fun updateLastLogin(user: User): Pair<Int, Response>
}