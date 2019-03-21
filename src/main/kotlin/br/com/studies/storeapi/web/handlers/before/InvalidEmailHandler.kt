package br.com.studies.storeapi.web.handlers.before

import br.com.studies.storeapi.commons.extensions.isEmailInvalid
import br.com.studies.storeapi.commons.text.EMAIL
import br.com.studies.storeapi.commons.text.EMAIL_MUST_BE_VALID_PAIR
import br.com.studies.storeapi.commons.text.INVALID_QUERY_STRING
import br.com.studies.storeapi.web.exceptions.BadRequestException
import io.javalin.Javalin

object InvalidEmailHandler {

    fun register(app: Javalin) {
        app.before("/verify") {
            it.queryParam(EMAIL, "")?.let { email ->
                if (email.isEmailInvalid()) throw BadRequestException(
                    INVALID_QUERY_STRING,
                    mapOf(EMAIL_MUST_BE_VALID_PAIR)
                )
            }
        }
    }
}