package com.yunnote.plugins

import com.yunnote.dto.Create
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.ktorm.database.Database
import org.ktorm.dsl.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/test") {

            // queryParameter를 받는 방법 1
            val let: Create.Request = call.parameters.let { params ->
                Create.Request(
                    name = params["name"] as String,
                    age = params["age"]?.toLongOrNull() ?: 0
                )
            }

            // queryParameter를 받는 방법 2
            val name: String? = call.request.queryParameters["name"];
            val age: String? = call.request.queryParameters["age"];


            // queryParameter를 받는 방법 3
            // call.parameters에 대한 확장함수를 만들어 받을 수 있게 제공하는법뿐


            call.respond("awef")
        }
    }
}

@Serializable
data class Test (
    private val name: String,
    private val age: Long,
)