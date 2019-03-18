package br.com.studies.storeapi.config

import br.com.studies.storeapi.resources.entities.Users
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    private val schemas: Array<Table> = arrayOf(Users)

    fun init(dataSource: HikariDataSource) {
        Database.connect(dataSource)
        transaction {
            SchemaUtils.create(*schemas)
        }
    }
}