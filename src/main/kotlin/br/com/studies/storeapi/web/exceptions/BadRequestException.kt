package br.com.studies.storeapi.web.exceptions

class BadRequestException(
    override val message: String,
    val details: Map<String, String>
) : RuntimeException(message)