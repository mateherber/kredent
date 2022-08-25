package org.kredent.login.ui.token

import androidx.lifecycle.ViewModel
import org.kredent.common.domain.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TokenViewModel @Inject constructor(
    private val tokenRepository: TokenRepository
) : ViewModel() {

    fun createToken() {
        tokenRepository.setToken(UUID.randomUUID().toString())
    }
}
