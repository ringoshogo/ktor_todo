package com.ringo.httpapi

import com.ringo.httpapi.routes.registerTodoRoutes

import io.ktor.application.Application
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod

import com.ringo.httpapi.service.DatabaseFactory
import com.ringo.httpapi.model.Todos
import org.jetbrains.exposed.sql.Database
import com.viartemev.ktor.flyway.FlywayFeature
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils

// jackson設定
import io.ktor.jackson.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

import io.ktor.gson.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(CallLogging)
    install(CORS){
        header(HttpHeaders.AccessControlAllowHeaders)
        method(HttpMethod.Delete)
        method(HttpMethod.Put)
        anyHost()
        allowNonSimpleContentTypes = true
        allowCredentials = true
    }
    install(ContentNegotiation) {
        gson{
        }
    }
    val db = DatabaseFactory.create()
    Database.connect(db)
    install(FlywayFeature) {
        dataSource = db
    }
    DatabaseFactory.initDB()

    registerTodoRoutes()
}
