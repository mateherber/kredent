package org.kredent.common.domain

import kotlinx.coroutines.flow.Flow

interface AuthKeyRepository {
    val authKey: Flow<String?>
    suspend fun setAuthKey(authKey: String?)
}
