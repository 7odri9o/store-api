package br.com.studies.storeapi.web.handlers.before

import br.com.studies.storeapi.commons.isEmailInvalid
import br.com.studies.storeapi.web.exceptions.BadRequestException
import io.javalin.Javalin

object InvalidEmailHandler {

    fun register(app: Javalin) {
        app.before("/verify") {
            it.queryParam("email", "")?.let { email ->
                if (email.isEmailInvalid()) {
                    val details = mapOf("email" to "Email must be a valid email")
                    val message = "Invalid Query String"
                    throw BadRequestException(message, details)
                }
            }
        }
    }
}