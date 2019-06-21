package com.bcp.app.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserLocalModel(
    @PrimaryKey var id: String,
    var login: String?,
    var avatarUrl: String?,
    var name: String?,
    var company: String?,
    var blog: String?
)