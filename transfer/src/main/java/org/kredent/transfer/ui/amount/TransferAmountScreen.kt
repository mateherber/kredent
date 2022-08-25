package org.kredent.transfer.ui.amount

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview
import org.kredent.designkit.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun TransferAmountScreen(viewModel: TransferAmountViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TransferAmountScreen(
        uiState.name,
        uiState.account,
        uiState.amount,
        viewModel::changeAmount,
        viewModel::finishTransferAmount,
        viewModel::goBack
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TransferAmountScreen(
    name: String,
    account: String,
    amount: String,
    onAmountChanged: (String) -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top)),
        topBar = {
            SmallTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                title = {}

            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding)
                    .padding(MaterialTheme.spacing.default),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = account,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Amount") },
                    value = amount,
                    onValueChange = onAmountChanged
                )
                Button(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.default)
                        .fillMaxWidth(),
                    onClick = onNextClick
                ) {
                    Text(text = "Next")
                }
            }
        })
}

@CombinedPreviews
@Composable
fun TransferAmountScreenPreview() {
    KredentPreview {
        TransferAmountScreen("Foo Bar", "12345678-00000000", "2432423.234234", {}, {}, {})
    }
}
