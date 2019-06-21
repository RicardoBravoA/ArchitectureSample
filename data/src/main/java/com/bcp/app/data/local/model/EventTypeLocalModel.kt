package com.bcp.app.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EventType")
data class EventTypeLocalModel(
    @PrimaryKey var id: Int,
    var name: String)