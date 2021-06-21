package com.ringo.httpapi.service

import com.ringo.httpapi.model.Todo
import com.ringo.httpapi.model.Todos
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat

class TodoService {

    companion object {val DEF_FMT = DateTimeFormat.forPattern("yyyy-MM-dd")}


    private fun toStrint(datetime: DateTime): String = DEF_FMT.print(datetime)

    fun getAllTodos(): List<Todo> = transaction{
        Todos.selectAll().map{ toTodo(it) }
    }

    fun createTodo(todo: Todo){
        transaction {
            Todos.insert { 
                it[userName] = todo.userName
                it[content] = todo.content
                it[expire] = DateTime.parse(todo.expire, DEF_FMT)
                it[importance] = todo.importance
                it[status] = todo.status
             }
        }
    }

    fun deleteTodo(id: Int) = transaction {
        Todos.deleteWhere { Todos.id eq id }
    }

    fun deleteTodos(ids: List<Int>) = transaction {
        Todos.deleteWhere { Todos.id inList ids }
    }

    fun updateTodo(id: Int, status: Int) = transaction {
        Todos.update({ Todos.id eq id}) {
            it[Todos.status] = status
        }
    }

    private fun toTodo(row: ResultRow): Todo =
        Todo(
            id = row[Todos.id],
            userName = row[Todos.userName],
            content = row[Todos.content],
            expire = toStrint(row[Todos.expire]),
            importance = row[Todos.importance],
            status = row[Todos.status]
        )
}