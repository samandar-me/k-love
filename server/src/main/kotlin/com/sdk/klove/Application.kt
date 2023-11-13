package com.sdk.klove

import Greeting
import SERVER_PORT
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.callloging.CallLogging
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.LoveResponse
import org.slf4j.event.Level

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = {
        configureSerialization()
        configureMonitoring()
        module()
    })
        .start(wait = true)
}

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Ktor: ${Greeting().greet()}")
        }
        get("/random") {
            //val request = call.receive<TextRequest>()
            val response = LoveResponse(generateRandomLove())
            call.respond(
                HttpStatusCode.OK,
                response
            )
        }
    }
}
private fun generateRandomLove(): Int = (0..100).random()
