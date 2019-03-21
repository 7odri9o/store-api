package br.com.studies.storeapi.domain.services.impl

import br.com.studies.storeapi.commons.text.EMAIL_NOT_REGISTERED_PAIR
import br.com.studies.storeapi.commons.text.USER_CREATED
import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.domain.services.UserService
import br.com.studies.storeapi.resources.entities.revert
import br.com.studies.storeapi.resources.repositories.UserRepository
import br.com.studies.storeapi.web.controllers.dto.Response
import br.com.studies.storeapi.web.controllers.dto.convertToResponse
import org.eclipse.jetty.http.HttpStatus
import java.util.*

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    override fun isAlreadyUser(email: String): Response {
        var statusCode: Int
        var status: String
        var message: String
        var details: Map<String, String>
        userRepository.findByEmail(email).let {
            if (it == null) {
                statusCode = HttpStatus.NOT_FOUND_404
                details = mapOf(EMAIL_NOT_REGISTERED_PAIR)
                message = "User Not Found"
            } else {
                statusCode = HttpStatus.OK_200
                details = mapOf("email" to email)
                message = "User Found"
            }
        }
        return Response(
            statusCode = statusCode,
            message = message,
            details = details
        )
    }

    override fun create(user: User): Response {
        val user = userRepository.save(user).revert()
        return convertToResponse(
            statusCode = HttpStatus.CREATED_201,
            message = USER_CREATED
        )
    }

    override fun findById(id: UUID, token: String): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByEmail(email: String): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateLastLogin(user: User): Pair<Int, Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}