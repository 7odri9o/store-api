package br.com.studies.storeapi.web.handlers

import br.com.studies.storeapi.web.handlers.before.EmailEmptyOrNullHandler
import br.com.studies.storeapi.web.handlers.before.InvalidEmailHandler
import br.com.studies.storeapi.web.handlers.exceptions.BadRequestHandler
import io.javalin.Javalin

object Handlers {

    fun register(app: Javalin) {

        EmailEmptyOrNullHandler.register(app)
        InvalidEmailHandler.register(app)

        BadRequestHandler.register(app)
    }
}