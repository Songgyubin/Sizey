package com.songgyubin.sizey.base

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) =
        this.compositeDisposable.add(disposable)

    override fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
        super.onCleared()
        Log.d(TAG, ": onCleared")
    }
    companion object{
    private const val TAG = "BaseViewModel.kt"
    }
}