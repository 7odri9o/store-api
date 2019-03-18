package br.com.studies.storeapi.web.controllers.dto

data class ErrorResponse(
    val message: String,
    val details: Map<String, String>
)