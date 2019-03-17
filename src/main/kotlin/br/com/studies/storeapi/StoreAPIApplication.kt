package br.com.studies.storeapi

import br.com.studies.storeapi.config.Server

fun main(args: Array<String>) {
    Server().setup().start()
}