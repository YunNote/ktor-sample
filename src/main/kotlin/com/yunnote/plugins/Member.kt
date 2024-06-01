package com.yunnote.plugins

import org.ktorm.entity.Entity


interface Member : Entity<Member>{

    companion object: Entity.Factory<Member>()

    val id: Long
    val name: String
    val age: Int
}