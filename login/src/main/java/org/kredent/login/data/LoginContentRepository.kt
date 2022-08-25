package org.kredent.login.data

import org.kredent.login.domain.ContentRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import kotlinx.coroutines.delay

@ViewModelScoped
class LoginContentRepository @Inject constructor() : ContentRepository {
    override suspend fun fetchContent(): String {
        delay(3000)
        return "This content is provided by Login Flow"
    }
}
