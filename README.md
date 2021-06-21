# TODO アプリ

 ちゅーとりあるとして React と ktor で簡易なTODOアプリを作成。

# 概要
 
 - 期限、重要度(高 > 中 > 低)、TODO内容を入力して送信すると、TODOが追加
![Videotogif (1)](https://user-images.githubusercontent.com/30945996/122807105-1f1a1680-d306-11eb-92b1-7ce65b6a5376.gif)

 - TODOの完了/未完了をクリックで切替
 - TODOをチェックした状態で「削除」ボタンを押下するとTODOを削除
 ![Videotogif (2)](https://user-images.githubusercontent.com/30945996/122807400-833cda80-d306-11eb-9479-d5f85708f932.gif)


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
