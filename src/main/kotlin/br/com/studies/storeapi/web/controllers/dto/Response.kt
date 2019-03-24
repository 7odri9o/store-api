package br.com.studies.storeapi.web.controllers.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude

data class Response(
    @JsonIgnore
    val statusCode: Int,
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val data: Any? = null,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val details: Map<String, String>? = null
)

fun convertToResponse(
    data: Any? = null,
    statusCode: Int,
    message: String,
    details: Map<String, String>? = null
): Response {
    return Response(
        statusCode = statusCode,
        message = message,
        data = data,
        details = details
    )
}