package com.example.todoapp.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
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
    suspend fun getAllTodos(): Flow<List<Todo>>

    //get todo by id
    @Query("SELECT * FROM todos WHERE Id = :id")
    suspend fun getTodoById(id: Int): Todo?

    // get items by todoId
    @Query("SELECT * FROM items WHERE todoId = :todoId")
    suspend fun getItemsByTodoId(todoId: Int): Flow<List<Item>>

}
