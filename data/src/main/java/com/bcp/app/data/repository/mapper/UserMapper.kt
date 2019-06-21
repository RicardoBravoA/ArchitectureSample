package com.bcp.app.data.repository.mapper

import com.bcp.app.data.local.model.UserLocalModel
import com.bcp.app.data.remote.model.UserRemoteModel

class UserMapper {

    fun remoteToLocal(user: UserRemoteModel) =
        UserLocalModel(user.id, user.login, user.avatarUrl, user.name, user.company, user.blog)
}