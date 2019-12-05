package com.example.matrixapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import com.example.matrixapplication.model.UserDetailsModel
import com.example.matrixapplication.utils.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class MainViewModel : ViewModel() {
    private val mainRepository: MainRepository = MainRepository()
    private val disposables = CompositeDisposable()

    val userResponseLiveData = MutableLiveData<Result<UserDetailsModel>>()

    fun userStatus(userId: Int) {

        disposables.add(mainRepository.getUserDetailRepo(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { userResponseLiveData.value = Result.loading() }
            .subscribeBy(
                onNext = { userResponseLiveData.value = it},
                onError = { userResponseLiveData.value = Result.failure(it)},
                onComplete = { println("onComplete!") }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}