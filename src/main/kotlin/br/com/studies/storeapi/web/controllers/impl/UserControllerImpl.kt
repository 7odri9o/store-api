package br.com.studies.storeapi.web.controllers.impl

import br.com.studies.storeapi.domain.services.UserService
import br.com.studies.storeapi.web.controllers.UserController
import io.javalin.Context

class UserControllerImpl(
    private val userService: UserService
) : UserController {

    override fun register(ctx: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAlreadyUser(ctx: Context) {

        val email = ctx.queryParam("email", "email")
        if (email.isNullOrBlank()) throw IllegalArgumentException("Email cannot be null or empty")
        val response = userService.isAlreadyUser(email)
        ctx.json(response.second).status(response.first)
    }

    override fun getUser(ctx: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}