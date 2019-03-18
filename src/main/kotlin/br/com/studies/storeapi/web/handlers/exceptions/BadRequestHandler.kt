package br.com.studies.storeapi.web.handlers.exceptions

import br.com.studies.storeapi.web.controllers.dto.ErrorResponse
import br.com.studies.storeapi.web.exceptions.BadRequestException
import io.javalin.Javalin
import org.eclipse.jetty.http.HttpStatus

object BadRequestHandler {

    fun register(app: Javalin) {
        app.exception(BadRequestException::class.java) { e, ctx ->
            val error = ErrorResponse(message = e.message, details = e.details)
            ctx.json(error).status(HttpStatus.BAD_REQUEST_400)
        }
    }
}