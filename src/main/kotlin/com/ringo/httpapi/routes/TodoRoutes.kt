package com.ringo.httpapi.routes

import io.ktor.routing.*
// call
import io.ktor.application.*
// respond
import io.ktor.response.*
// receive
import io.ktor.request.*
// HttpStatusCode
import io.ktor.http.HttpStatusCode
import com.ringo.httpapi.service.TodoService
import com.ringo.httpapi.model.Todo

fun Route.todoRouting() {
    val todoService = TodoService()

    route("/todo") {
        get{
            call.respond(
                HttpStatusCode.OK,
                todoService.getAllTodos()
            )
        }
        post{
            val result = call.receive<Todo>()
            todoService.createTodo(result)
            call.respond(HttpStatusCode.OK)
        }
        delete("{id}") {
            call.parameters["id"]?.let { id ->
                todoService.deleteTodo(id.toInt())
            }
            call.respond(HttpStatusCode.OK)
        }
        delete {
            val ids = call.receive<Ids>()
            todoService.deleteTodos(ids.idList.map { it.toInt() })
            call.respond(HttpStatusCode.OK)
        }
        put("{id}") {
            val status = call.receive<Status>()
            call.parameters["id"]?.let { id -> 
                todoService.updateTodo(id.toInt(), status.status)
            }
            call.respond(HttpStatusCode.OK)
        }
    }
}

data class Ids(val idList: List<String>)
data class Status(val status: Int)

fun Application.registerTodoRoutes() {
    routing {
        todoRouting()
    }
}