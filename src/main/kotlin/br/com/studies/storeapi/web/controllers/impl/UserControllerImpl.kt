package br.com.studies.storeapi.web.controllers.impl

import br.com.studies.storeapi.commons.extensions.getNonNullValue
import br.com.studies.storeapi.commons.text.EMAIL
import br.com.studies.storeapi.domain.services.UserService
import br.com.studies.storeapi.web.controllers.UserController
import br.com.studies.storeapi.web.controllers.dto.UserDTO
import br.com.studies.storeapi.web.controllers.dto.convert
import io.javalin.Context

class UserControllerImpl(
    private val userService: UserService
) : UserController {

    override fun register(ctx: Context) {
        val response = userService.create(ctx.body<UserDTO>().convert())
        ctx.json(response).status(response.statusCode)
    }

    override fun isAlreadyUser(ctx: Context) {
        val email = ctx.queryParam(EMAIL, "").getNonNullValue()
        val response = userService.isAlreadyUser(email)
        ctx.json(response).status(response.statusCode)
    }

    override fun getUser(ctx: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}