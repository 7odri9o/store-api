package br.com.studies.storeapi.domain.services.impl

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.domain.services.UserService
import br.com.studies.storeapi.resources.entities.revert
import br.com.studies.storeapi.resources.repositories.UserRepository
import br.com.studies.storeapi.web.controllers.dto.ErrorResponse
import br.com.studies.storeapi.web.controllers.dto.Response
import org.eclipse.jetty.http.HttpStatus
import java.util.*

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun isAlreadyUser(email: String): Pair<Int, Response> {
        var statusCode: Int
        var data: Any
        userRepository.findByEmail(email).let {
            if (it == null) {
                statusCode = HttpStatus.NOT_FOUND_404
                data = ErrorResponse(
                    message = "User Not Found",
                    details = mapOf("email" to "Email not registered")
                )
            } else {
                statusCode = HttpStatus.OK_200
                data = it.revert()
            }
        }
        return statusCode to Response(
            status = "success",
            data = data
        )
    }

    override fun create(user: User): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: UUID, token: String): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByEmail(email: String): Pair<Int, Response> {
        val user = userRepository.findByEmail(email)
        println("test")
        return 200 to Response(
            status = "success",
            data = User(
                email = user?.email!!
            )
        )
    }

    override fun updateLastLogin(user: User): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}