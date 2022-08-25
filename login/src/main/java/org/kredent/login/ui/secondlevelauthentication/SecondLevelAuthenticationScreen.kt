package org.kredent.login.ui.secondlevelauthentication

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview
import org.kredent.designkit.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun SecondLevelAuthenticationScreen(viewModel: SecondLevelAuthenticationViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SecondLevelAuthenticationScreen(uiState, viewModel::authenticate)
}

@Composable
private fun SecondLevelAuthenticationScreen(
    viewState: SecondLevelAuthenticationViewState,
    onAuthenticationClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top))
            .padding(MaterialTheme.spacing.default),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.default,
            Alignment.CenterVertically
        )
    ) {
        Crossfade(
            targetState = viewState is Content,
            modifier = Modifier.fillMaxWidth()
        ) { isContent ->
            if (isContent) Box(
                modifier = Modifier
                    .height(MaterialTheme.spacing.xl)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = (viewState as Content).message,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            } else Box(
                modifier = Modifier
                    .height(MaterialTheme.spacing.xl)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onAuthenticationClick,
        ) {
            Text(
                "Second Level Authentication",
            )
        }
    }
}

@CombinedPreviews
@Composable
fun SecondLevelAuthenticationScreenPreview() {
    KredentPreview {
        SecondLevelAuthenticationScreen(Content("FooBar")) {
        }
    }
}
