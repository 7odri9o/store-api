package br.com.studies.storeapi.config

import br.com.studies.storeapi.config.Modules.allModules
import br.com.studies.storeapi.web.Routes
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
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

        DatabaseFactory.init(getDBConfig())

        return Javalin.create()
            .also { app ->
                app.contextPath(getProperty("context"))
                routes.register(app)
                app.port(getProperty("server_port"))
            }
    }

    private fun getDBConfig(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = getProperty("jdbc.url")
        config.username = getProperty("db.username")
        config.password = getProperty("db.password")
        config.validate()
        return HikariDataSource(config)
    }
}