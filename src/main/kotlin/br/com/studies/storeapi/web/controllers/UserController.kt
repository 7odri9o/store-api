package br.com.studies.storeapi.web.controllers

import io.javalin.Context

interface UserController {

    fun register(ctx: Context)
    fun isAlreadyUser(ctx: Context)
    fun getUser(ctx: Context)
}