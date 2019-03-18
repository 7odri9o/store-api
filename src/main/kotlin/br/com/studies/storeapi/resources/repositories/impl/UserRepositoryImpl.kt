package br.com.studies.storeapi.resources.repositories.impl

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.resources.entities.UserEntity
import br.com.studies.storeapi.resources.entities.Users
import br.com.studies.storeapi.resources.repositories.UserRepository
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class UserRepositoryImpl : UserRepository {

    override fun save(user: User): UserEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun countByEmail(email: String): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByEmail(email: String): UserEntity? {
        return transaction {
            UserEntity.find { Users.email eq email }.firstOrNull()
        }
    }

    override fun findById(id: UUID): UserEntity? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLastLogin(user: User): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}