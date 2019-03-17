package br.com.studies.storeapi.config

import br.com.studies.storeapi.config.Modules.allModules
import br.com.studies.storeapi.web.Routes
import io.javalin.Javalin
import org.koin.core.KoinProperties
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.getProperty
import org.koin.standalone.inject

class Server : KoinComponent {

    private val routes: Routes by inject()

    fun setup(): Javalin {
        StandAloneContext.startKoin(
            allModules,
            KoinProperties(true, true)
        )

        return Javalin.create()
            .also { app ->
                app.enableCorsForAllOrigins()
                    .contextPath(getProperty("context"))
                routes.register(app)
                app.port(getProperty("server_port"))
            }
    }
}