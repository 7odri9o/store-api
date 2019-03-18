package br.com.studies.storeapi.web.handlers.before

import br.com.studies.storeapi.web.exceptions.BadRequestException
import io.javalin.Javalin

object EmailEmptyOrNullHandler {

    fun register(app: Javalin) {
        app.before("/verify") {
            it.queryParam("email", "").let { email ->
                if (email.isNullOrBlank()) {
                    val details = mapOf("email" to "Email must be in the query string")
                    val message = "Invalid Query String"
                    throw BadRequestException(message, details)
                }
            }
        }
    }
}