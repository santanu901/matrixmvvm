package com.example.matrixapplication.network.api

import android.util.Log
import com.example.matrixapplication.common.AppConstant
import com.example.matrixapplication.model.UserDetailsModel
import com.example.matrixapplication.utils.Result
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TypiCodeService {

    @GET(AppConstant.REQUEST_TYPE_USER_DETAILS)
    fun getUserDetails(@Path("id") userId: Int): Observable<Result<UserDetailsModel>>

    companion object {
        val typiCodeApi: TypiCodeService by lazy {

            return@lazy Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
                .create(TypiCodeService::class.java)
        }
    }
}