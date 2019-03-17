package br.com.studies.storeapi.web.controllers.impl

import br.com.studies.storeapi.domain.dto.User
import br.com.studies.storeapi.web.controllers.UserController
import br.com.studies.storeapi.web.controllers.dto.Response
import io.javalin.Context
import org.eclipse.jetty.http.HttpStatus

class UserControllerImpl : UserController {

    override fun register(ctx: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isAlreadyUser(ctx: Context) {

        val email = ctx.queryParam("email", "email")
        if (email.isNullOrBlank()) throw IllegalArgumentException("Email cannot be null or empty")
        val user = User(email)
        val response = Response("success", user)
        ctx.json(response).status(HttpStatus.OK_200)
    }

    override fun getUser(ctx: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}