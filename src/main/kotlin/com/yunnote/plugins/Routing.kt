package com.yunnote.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.ktorm.database.Database
import org.ktorm.dsl.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/json-test") {

            call.respond( JsonSample("YunNote", "최윤진", Priority.High)
            )
        }

        get("/test") {
            val database = Database.connect(
                dataSource = HikariDataSource(HikariConfig().apply {
                    jdbcUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC"
                    driverClassName = "com.mysql.cj.jdbc.Driver"
                    username = "root"
                    password = "1234"
                })
            )

            database.insert(MemberTable) {
                set(it.name, "YunNote")
                set(it.age, 32)
            }

            val query = database.from(MemberTable)
                .select()
                .where { MemberTable.name eq "YunNote" }

            val row = query.iterator().asSequence().firstOrNull();

            if (row != null) {
                val id = row[MemberTable.id]
                val name = row[MemberTable.name]
                val age = row[MemberTable.age]
                call.respondText("ID: $id, Name: $name, Age: $age")
            }
            call.respondText("No member found with name 'YunNote'")
        }
    }
}
