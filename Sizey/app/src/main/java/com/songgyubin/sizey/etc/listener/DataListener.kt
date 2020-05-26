package com.songgyubin.sizey.etc.listener

interface DataListener<T> {
    fun onSuccess(t: T)
    fun onFail(e: Throwable)
}