package com.bcp.app.data.gateway.mapper

import com.bcp.app.data.local.model.UserLocalModel
import com.bcp.app.domain.entity.UserEntity

class UserGatewayMapper {

    fun toLocalEntity(userLocalModel: UserLocalModel) =
        UserEntity(
            userLocalModel.id,
            userLocalModel.login,
            userLocalModel.avatarUrl,
            userLocalModel.name,
            userLocalModel.company,
            userLocalModel.blog
        )
}