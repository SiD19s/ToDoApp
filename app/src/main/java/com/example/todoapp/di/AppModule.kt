package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.features_todo.Data.data_source.TodoDatabase
import com.example.todoapp.features_todo.Data.repository.TodoRepositoryImplementation
import com.example.todoapp.features_todo.Domain.repository.TodoRepository
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.DeleteTodoAndItems
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.DeleteTodoItem
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.GetAllTodosWithItems
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.GetTodoWithItems
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.InsertTodoAndItems
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.InsertTodoItem
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases.TodoUsecases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase{
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db:TodoDatabase) : TodoRepository{
        return TodoRepositoryImplementation(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoUsecases(repository: TodoRepository): TodoUsecases {
        return TodoUsecases(
            getAllTodosWithItems = GetAllTodosWithItems(repository),
            getTodoWithItems = GetTodoWithItems(repository),
            insertTodoAndItems = InsertTodoAndItems(repository),
            deleteTodoAndItems = DeleteTodoAndItems(repository),
            insertTodoItem = InsertTodoItem(repository),
            deleteTodoItem = DeleteTodoItem(repository)

        )
    }

}

