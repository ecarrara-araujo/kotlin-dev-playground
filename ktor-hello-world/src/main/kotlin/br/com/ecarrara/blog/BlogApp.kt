package br.com.ecarrara.blog

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get {
            call.respondText("My Example Blog2", ContentType.Text.Html)
        }
    }
}