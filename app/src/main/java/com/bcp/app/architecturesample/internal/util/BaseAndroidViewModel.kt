package com.bcp.app.architecturesample.internal.util

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

abstract class BaseAndroidViewModel : AndroidViewModel {

    protected val context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }

    private val disposables = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        disposables += disposable
    }

    override fun onCleared() {
        disposables.dispose()
    }
}