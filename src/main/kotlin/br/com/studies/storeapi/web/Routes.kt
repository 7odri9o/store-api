package br.com.studies.storeapi.web

import io.javalin.Javalin
import org.koin.standalone.KoinComponent

class Routes : KoinComponent {

    fun register(app: Javalin) {
        println("Registering HTTP Routes")
    }
}