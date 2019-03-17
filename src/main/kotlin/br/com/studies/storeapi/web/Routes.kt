package br.com.studies.storeapi.web

import br.com.studies.storeapi.web.controllers.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.path
import org.koin.standalone.KoinComponent

class Routes(
    private val userController: UserController
) : KoinComponent {

    fun register(app: Javalin) {
        app.routes {
            path("verify") {
                get(userController::isAlreadyUser)
            }
        }
    }
}