package com.yunnote.plugins

import kotlinx.serialization.Serializable

@Serializable
data class JsonSample(
    val name: String,
    val description: String,
    val priority: Priority
)

enum class  Priority {
    Low, Medium, High
}
