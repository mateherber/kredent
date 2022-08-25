package org.kredent.common.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import org.kredent.common.domain.AuthKeyRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

@Singleton
class AuthKeyRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : AuthKeyRepository {
    private object PreferencesKeys {
        val AUTH_KEY = stringPreferencesKey("auth_key")
    }

    override val authKey: Flow<String?>
        get() = dataStore.data
            .map { it[PreferencesKeys.AUTH_KEY] }
            .catch { emit(null) }

    override suspend fun setAuthKey(authKey: String?) {
        dataStore.edit {
            if (authKey != null) {
                it[PreferencesKeys.AUTH_KEY] = authKey
            } else {
                it.remove(PreferencesKeys.AUTH_KEY)
            }
        }
    }
}
