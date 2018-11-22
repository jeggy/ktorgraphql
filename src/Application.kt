package net.jebster

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import net.jebster.graphql.schema

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(CORS) {
        method(HttpMethod.Delete)
        method(HttpMethod.Get)
        method(HttpMethod.Head)
        method(HttpMethod.Options)
        method(HttpMethod.Patch)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        header(HttpHeaders.Authorization)
        header(HttpHeaders.CacheControl)
        header(HttpHeaders.ContentLanguage)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.Expires)
        header(HttpHeaders.LastModified)
        header(HttpHeaders.Pragma)
        header("MyCustomHeader")
        header("x-apollo-tracing")

        host("www.graphqlbin.com", listOf("https"))
        host("localhost:3000")

        allowCredentials = true
    }

    install(ContentNegotiation) { gson() }

    routing {
        post("/graphql") {
            val request = call.receive<GraphQLRequest>()
            println(request.query)
            call.respond(schema.execute(request.query ?: request.mutation!!))
        }
    }
}

