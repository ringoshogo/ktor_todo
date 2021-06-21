package com.ringo.httpapi.db.migragion

import com.ringo.httpapi.model.Todos
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.jetbrains.exposed.sql.*

class V1__create_todos: BaseJavaMigration() {
    override fun migrate(context: Context?) {
        transaction {
            SchemaUtils.create(Todos)

            Todos.insert { 
                it[userName] = "a1"
                it[content] = "nantoka"
                it[expire] = DateTime.now()
                it[importance] = 1
                it[status] = 1
             }

        }
    }
}