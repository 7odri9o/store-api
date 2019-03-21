package br.com.studies.storeapi.web.handlers.exceptions

import br.com.studies.storeapi.web.controllers.dto.Response
import br.com.studies.storeapi.web.exceptions.BadRequestException
import io.javalin.Javalin
import org.eclipse.jetty.http.HttpStatus

object BadRequestHandler {

    fun register(app: Javalin) {
        app.exception(BadRequestException::class.java) { e, ctx ->
            val response = Response(
                statusCode = HttpStatus.BAD_REQUEST_400,
                message = "Invalid Payload",
                details = e.details
            )
            ctx.json(response).status(response.statusCode)
        }
    }
}