package org.kredent.transactions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
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
import org.kredent.designkit.palette.ProgressButton
import org.kredent.designkit.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun TransactionsScreen(viewModel: TransactionsViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TransactionsScreen(
        transactionsState = uiState,
        onAuthClick = viewModel::requestTransactions,
        onFooClick = viewModel::startTransfer
    )
}

@Composable
private fun TransactionsScreen(
    transactionsState: TransactionsState,
    onAuthClick: () -> Unit,
    onFooClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top))
            .padding(MaterialTheme.spacing.default),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.default,
            Alignment.CenterVertically
        )
    ) {
        ProgressButton(
            loading = transactionsState == TransactionsState.LOADING,
            text = "Trigger Auth",
            onClick = onAuthClick
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onFooClick
        ) {
            Text("Start Transfer")
        }
    }
}

@CombinedPreviews
@Composable
fun SecondLevelAuthenticationScreenPreview() {
    KredentPreview {
        TransactionsScreen(TransactionsState.IDLE, onAuthClick = { }, onFooClick = {})
    }
}
