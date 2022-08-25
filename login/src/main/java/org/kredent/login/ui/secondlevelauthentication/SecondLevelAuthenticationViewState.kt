package org.kredent.login.ui.secondlevelauthentication

sealed interface SecondLevelAuthenticationViewState
data class Content(
    val message: String
) : SecondLevelAuthenticationViewState

object Loading : SecondLevelAuthenticationViewState
