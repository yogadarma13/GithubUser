package com.yogadarma.consumerapp.framework.utils

import com.yogadarma.consumerapp.rx.SchedulerProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class DefaultSchedulerProvider : SchedulerProvider {
    override val mainThread: Scheduler
        get() = AndroidSchedulers.mainThread()

    override val io: Scheduler
        get() = Schedulers.io()

    override val newThread: Scheduler
        get() = Schedulers.newThread()
}