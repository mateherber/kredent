package org.kredent.login.ui.secondlevelauthentication

interface SecondLevelAuthenticationCoordinator {
    suspend fun authenticate()
    suspend fun fetchContent(): String
}
