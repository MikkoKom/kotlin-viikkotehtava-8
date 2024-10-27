package com.example.viikko8.api

import com.example.viikko8.model.Todo
import retrofit2.http.GET

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}
