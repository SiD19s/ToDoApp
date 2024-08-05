package com.example.todoapp.features_todo.Data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.todoapp.features_todo.Domain.model.Item
import com.example.todoapp.features_todo.Domain.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    //Insert and Update in Todo
    @Upsert()
    suspend fun insertTodo(todo: Todo)

    //Insert and Update in Item
    @Upsert
    suspend fun insertItem(item: Item)

    //Delete in Todo
    @Delete()
    suspend fun deleteTodo(todo: Todo)

    //Delete in Item
    @Delete()
    suspend fun deleteItem(item: Item)

    // get all todo
    @Query("SELECT * FROM todos")
    fun getAllTodos(): Flow<List<Todo>>

    //get todo by id
    @Query("SELECT * FROM todos WHERE Id = :id")
    suspend fun getTodoById(id: Int): Todo?

    // get items by todoId
    @Query("SELECT * FROM items WHERE todoId = :todoId")
    fun getItemsByTodoId(todoId: Int): Flow<List<Item>>

}
