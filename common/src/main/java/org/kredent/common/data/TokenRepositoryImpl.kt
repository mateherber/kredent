package org.kredent.common.data

import org.kredent.common.domain.TokenRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class TokenRepositoryImpl @Inject constructor() : TokenRepository {
    private val _token = MutableStateFlow<String?>(null)
    override val token: Flow<String?> = _token.asStateFlow()

    override fun setToken(token: String?) {
        _token.value = token
    }
}
