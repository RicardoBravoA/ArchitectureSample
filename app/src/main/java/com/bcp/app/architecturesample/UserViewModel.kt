package com.bcp.app.architecturesample

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.bcp.app.architecturesample.internal.util.BaseAndroidViewModel
import com.bcp.app.domain.entity.UserEntity
import com.bcp.app.domain.interactor.UserUseCase
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver

class UserViewModel(context: Context, private val useCase: UserUseCase) :
    BaseAndroidViewModel(context.applicationContext as Application) {

    val loading = ObservableBoolean()
    val result = ObservableArrayList<UserEntity>()
    val empty = ObservableBoolean()
    val error = ObservableField<String>()
    val response = ObservableField<String>()

    fun loadUser() = addDisposable(getUser())

    private fun getUser(): Disposable {
        return useCase.execute()
            .subscribeWith(object : DisposableSingleObserver<UserEntity>() {

                override fun onStart() {
                    loading.set(true)
                }

                override fun onSuccess(t: UserEntity) {
                    loading.set(false)
                    result.clear()
                    result.add(t)
                    response.set(t.toString())
                }


                override fun onError(t: Throwable) {
                    loading.set(false)
                    error.set(t.localizedMessage ?: t.message ?: "Ocurrió un error")
                }

            })
    }
}