package com.bcp.app.architecturesample.internal.scheduler

import com.bcp.app.domain.Schedulers
import io.reactivex.Scheduler

class AppSchedulers : Schedulers {

    override val subscribeOn: Scheduler
        get() = io.reactivex.schedulers.Schedulers.io()

    override val observeOn: Scheduler
        get() = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
}
