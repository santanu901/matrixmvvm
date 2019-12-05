package com.example.matrixapplication.ui.main

import com.example.matrixapplication.model.UserDetailsModel
import com.example.matrixapplication.network.api.TypiCodeService
import com.example.matrixapplication.utils.Result
import io.reactivex.Observable

class MainRepository {

    fun getUserDetailRepo(userId: Int): Observable<Result<UserDetailsModel>> {
        return TypiCodeService.typiCodeApi.getUserDetails(userId)
    }
}