package com.songgyubin.sizey.data.local

data class User(
    val userId:String,
    val userPw:String,
    var userNick: String? = null
)