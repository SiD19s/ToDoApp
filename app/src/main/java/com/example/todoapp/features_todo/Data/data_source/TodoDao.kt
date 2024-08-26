package com.example.todoapp.features_todo.Data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import com.example.todoapp.features_todo.Domain.model.Todo
import com.example.todoapp.features_todo.Domain.model.TodoItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Transaction
    @Query("SELECT * FROM todos")
    fun getAllTodosWithItems(): Flow<List<TodoWithItems>>

    @Transaction
    @Query("SELECT * FROM todos WHERE id = :todoId")
    suspend fun getTodoWithItems(todoId: Long): TodoWithItems?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoAndItems(todo: Todo, items: List<TodoItem>)

    @Delete
    suspend fun deleteTodoAndItems(todo: Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodoItem(item: TodoItem)

    @Query("DELETE FROM todo_items WHERE itemId = :itemId")
    suspend fun deleteTodoItem(itemId: Long)


}

data class TodoWithItems(
    @Embedded val todo: Todo,
    @Relation(
        parentColumn = "id",
        entityColumn = "todoId"
    )
    val items: List<TodoItem>
)


