package org.kredent.login.domain

interface ContentRepository {
    suspend fun fetchContent(): String
}
