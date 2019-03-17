package br.com.studies.storeapi.config

import br.com.studies.storeapi.web.Routes
import br.com.studies.storeapi.web.controllers.UserController
import br.com.studies.storeapi.web.controllers.impl.UserControllerImpl
import org.koin.dsl.module.module

object Modules {

    private val configModule = module {
        single { Server() }
        single { Routes(get()) }
    }

    private val userModule = module {
        single { UserControllerImpl() as UserController }
    }

    internal val allModules = listOf(
        configModule,
        userModule
    )
}