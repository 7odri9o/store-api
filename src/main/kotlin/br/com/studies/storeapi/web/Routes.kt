package br.com.studies.storeapi.web

import br.com.studies.storeapi.web.controllers.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import org.koin.standalone.KoinComponent

class Routes(
    private val userController: UserController
) : KoinComponent {

    fun register(app: Javalin) {
        app.routes {
            path("verify") {
                get(userController::isAlreadyUser)
            }
            path("users") {
                post(userController::register)
            }
        }
    }
}