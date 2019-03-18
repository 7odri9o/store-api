package br.com.studies.storeapi.resources.entities

import br.com.studies.storeapi.domain.dto.User
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import java.util.*

class UserEntity(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, UserEntity>(Users)

    var email by Users.email
}

fun UserEntity.revert(): User {
    return User(
        email = this.email
    )
}