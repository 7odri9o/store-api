package br.com.studies.storeapi.config

import br.com.studies.storeapi.web.Routes
import org.koin.dsl.module.module

object Modules {

    private val configModule = module {
        single { Server() }
        single { Routes() }
    }

    internal val allModules = listOf(
        configModule
    )
}