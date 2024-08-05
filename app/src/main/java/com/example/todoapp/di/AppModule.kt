package com.example.todoapp.di

import android.app.Application
import androidx.room.Room
import com.example.todoapp.features_todo.Data.data_source.TodoDatabase
import com.example.todoapp.features_todo.Data.repository.TodoRepositoryImplementation
import com.example.todoapp.features_todo.Domain.repository.TodoRepository
import com.example.todoapp.features_todo.Domain.use_case.DeleteTodoUsecase
import com.example.todoapp.features_todo.Domain.use_case.GetTodoUsecase
import com.example.todoapp.features_todo.Domain.use_case.TodoUsecases
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
    fun provideTodoUsecases(repository: TodoRepository): TodoUsecases{
        return TodoUsecases(
            getTodoUsecase = GetTodoUsecase(repository),
            deleteTodoUsecase = DeleteTodoUsecase(repository)
        )
    }

}

