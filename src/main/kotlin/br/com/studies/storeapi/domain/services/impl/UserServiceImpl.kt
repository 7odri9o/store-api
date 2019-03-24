package br.com.studies.storeapi.domain.services.impl

import br.com.studies.storeapi.commons.text.EMAIL_NOT_REGISTERED_PAIR
import br.com.studies.storeapi.commons.text.USER_CREATED
import br.com.studies.storeapi.commons.text.USER_FOUND_MESSAGE
import br.com.studies.storeapi.commons.text.USER_NOT_FOUND_MESSAGE
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

        userRepository.findByEmail(email)
            .takeIf { it != null }?.apply {
                return convertToResponse(
                    data = this.revert(),
                    statusCode = HttpStatus.OK_200,
                    message = USER_FOUND_MESSAGE
                )
            }.let {
                return convertToResponse(
                    data = User(email = email),
                    statusCode = HttpStatus.NOT_FOUND_404,
                    message = USER_NOT_FOUND_MESSAGE,
                    details = mapOf(EMAIL_NOT_REGISTERED_PAIR)
                )
            }
    }

    override fun create(user: User): Response {
        userRepository.save(user)
            .let {
                return convertToResponse(
                    statusCode = HttpStatus.CREATED_201,
                    message = USER_CREATED
                )
            }

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

    private fun formatResponse(
        user: User?,
        statusCode: Int,
        message: String,
        details: Map<String, String>?
    ): Response {
        return Response(
            statusCode = statusCode,
            message = message,
            data = user,
            details = details
        )
    }
}