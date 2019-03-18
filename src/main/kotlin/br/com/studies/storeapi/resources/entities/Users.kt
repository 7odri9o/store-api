package br.com.studies.storeapi.resources.entities

import org.jetbrains.exposed.dao.UUIDTable

internal object Users : UUIDTable() {

    val email = Users.varchar("email", 200).uniqueIndex()
}