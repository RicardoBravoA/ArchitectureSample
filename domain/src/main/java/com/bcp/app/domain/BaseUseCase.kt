package com.bcp.app.domain

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

abstract class BaseUseCase<in Params, Result> internal constructor(private val schedulers: Schedulers) {

    private var disposable: CompositeDisposable = CompositeDisposable()

    internal abstract fun buildSingle(params: Params?): Single<Result>

    fun execute(params: Params? = null): Single<Result> {
        return buildSingle(params)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
    }

}