package com.bcp.app.architecturesample

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.bcp.app.architecturesample.internal.util.BaseAndroidViewModel
import com.bcp.app.domain.entity.EventType
import com.bcp.app.domain.interactor.EventTypeGetAllUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

class EventViewModel(context: Context, private val eventTypeGetAllUseCase: EventTypeGetAllUseCase)
    : BaseAndroidViewModel(context.applicationContext as Application) {

    val loading = ObservableBoolean()
    val result = ObservableArrayList<EventType>()
    val empty = ObservableBoolean()
    val error = ObservableField<String>()

    fun loadEventTypeList() = addDisposable(getAllEventTypes())

    private fun getAllEventTypes(): Disposable {
        return eventTypeGetAllUseCase.execute()
            .subscribeWith(object : DisposableObserver<List<EventType>>() {

                override fun onStart() {
                    loading.set(true)
                }

                override fun onNext(t: List<EventType>) {
                    loading.set(false)
                    result.clear()
                    result.addAll(t)
                    empty.set(t.isEmpty())
                }

                override fun onError(t: Throwable) {
                    loading.set(false)
                    error.set(t.localizedMessage ?: t.message ?: "Ocurrió un error")
                }

                override fun onComplete() {
                    // no-op
                }
            })
    }
}