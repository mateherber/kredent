package org.kredent.common.domain

import kotlinx.coroutines.flow.Flow

interface TokenRepository {
    val token: Flow<String?>
    fun setToken(token: String?)
}
