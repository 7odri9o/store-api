package br.com.studies.storeapi.resources.repositories

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.resources.entities.UserEntity
import java.util.*

interface UserRepository {

    fun save(user: User): UserEntity
    fun countByEmail(email: String): Int
    fun findByEmail(email: String): UserEntity?
    fun findById(id: UUID): UserEntity?
    fun updateLastLogin(user: User): Int
}