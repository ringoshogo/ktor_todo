# TODO アプリ

 ちゅーとりあるとして React と ktor で簡易なTODOアプリを作成。

## React × Kotlin

### Frontend(React)

The application was built with:

  - [React](https://github.com/facebook/react) as JavaScript library
  - [Redux](https://github.com/reduxjs/redux) as predictable state container
  - [React Redux](https://github.com/reduxjs/react-redux) as predictable state container
  - [Redux Thunk](https://github.com/reduxjs/redux-thunk) as middleware for Redux
  - [axios](https://github.com/axios/axios) as HTTP client for the browserjs
  - [Material-UI](https://github.com/mui-org/material-ui) as component library for react

### Backend(kotlin)

The application was built with:

  - [Kotlin](https://github.com/JetBrains/kotlin) as programming language
  - [Ktor](https://github.com/ktorio/ktor) as web framework
  - [gson](https://github.com/google/gson) as data bind serialization/deserialization
  - [HikariCP](https://github.com/brettwooldridge/HikariCP) as JDBC connection pool
  - [H2](https://github.com/h2database/h2database) as database
  - [Exposed](https://github.com/JetBrains/Exposed) as Sql framework to persistence layer
  - [flyway](https://github.com/viartemev/ktor-flyway-feature) as DB initialization


### TO DO

 - Testを作成する
 - DBをMySqlへ置き換える
 - KoinでServiceクラスをDIコンテナで管理する
 - ログイン機能を追加する
 - SessionStorageとしてRedisを使用する

### HOW TO START

#### START KTOR
 - ./gradlew run

#### START REACT
 - cd src-react\todo-app
 - npm install
 - npm start
