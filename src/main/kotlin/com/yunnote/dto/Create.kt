package com.yunnote.dto

import kotlinx.serialization.Serializable


class Create {

    @Serializable
    data class Request(val name: String, val age: Long)

    @Serializable
    data class Response (val name:String, val age:Long)
}