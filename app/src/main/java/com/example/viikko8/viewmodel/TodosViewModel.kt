package com.example.viikko8.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viikko8.api.ApiService
import com.example.viikko8.model.Todo
import kotlinx.coroutines.launch

class TodosViewModel : ViewModel() {
    val todos = MutableLiveData<List<Todo>>()

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            try {
                val todoList = ApiService.api.getTodos()
                todos.postValue(todoList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
