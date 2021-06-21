package com.ringo.httpapi.model

import java.util.Date
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import kotlinx.datetime.*
import org.jetbrains.exposed.dao.id.EntityID
import org.joda.time.DateTime
// ↓ https://github.com/JetBrains/Exposed/issues/765
import org.jetbrains.exposed.sql.jodatime.datetime

//https://stefangaller.at/app-development/kotlin/ktor-rest-api-exposed/
//Data Persistence の記載方法

// これはいるのか？➡レスポンスの値として使用する

// @serializableを付与するとエラーになる
// @Serializable
data class Todo(
    /** ID */
    val id: Int,
    /** ユーザー */
    val userName: String,
    /** TODOの内容 */
    val content: String,
    /** 期限 */
    val expire: String,
    /** 重要度 */
    val importance: Int,
    /** 状態：完了=1/未完了=0 */
    val status: Int
    )

//DSL/DAO共通のテーブル
object Todos : Table() {
    val id = integer("id").autoIncrement()
    val userName = varchar("userId", 20)
    val content = varchar("content", 100)
    val expire = datetime("expire")
    val importance = integer("importance")
    val status = integer("status").default(1)
    override val primaryKey = PrimaryKey(id)
}