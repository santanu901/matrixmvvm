package com.example.matrixapplication.utils

sealed class Result<T> {
    class Loading<T> : Result<T>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure<T>(val message: Throwable) : Result<T>()

    companion object {
        fun <T> loading(): Result<T> = Loading()
        fun <T> success(data: T): Result<T> = Success(data)
        fun <T> failure(message: Throwable): Result<T> = Failure(message)
    }
}