package org.kredent.transfer.ui.summary

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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import org.kredent.designkit.palette.ProgressButton
import org.kredent.designkit.theme.spacing

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun TransferSummaryScreen(viewModel: TransferSummaryViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TransferSummaryScreen(
        uiState.name,
        uiState.account,
        uiState.message,
        uiState.amount,
        uiState.transferPending,
        viewModel::finishTransferSummary,
        viewModel::goUp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TransferSummaryScreen(
    name: String,
    account: String,
    message: String,
    amount: String,
    loading: Boolean,
    onNextClick: () -> Unit,
    onCloseClick: () -> Unit
) {
    Scaffold(modifier = Modifier
        .fillMaxWidth()
        .windowInsetsPadding(WindowInsets.statusBars.only(WindowInsetsSides.Top)),
        topBar = {
            SmallTopAppBar(
                navigationIcon = {
                    IconButton(onClick = onCloseClick) {
                        Icon(Icons.Filled.Close, null)
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
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = amount,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                ProgressButton(
                    loading = loading,
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.default)
                        .fillMaxWidth(),
                    onClick = onNextClick,
                    text = "Next",
                )
            }
        })
}

@CombinedPreviews
@Composable
fun TransferSummaryScreenPreview() {
    KredentPreview {
        TransferSummaryScreen(
            "Foo Bar",
            "123456789",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam pharetra purus sed sapien facilisis imperdiet. Morbi in aliquet enim. Sed diam turpis, sodales a ipsum in, viverra blandit tortor. Quisque commodo justo congue tortor dapibus, ut congue tellus bibendum. Vestibulum iaculis nisl ornare, lobortis sem ullamcorper, tempor lacus. Duis pellentesque est fermentum, venenatis purus vel, tristique erat. Morbi dignissim tortor laoreet sagittis dignissim. Sed viverra facilisis orci, sit amet condimentum neque semper ac",
            "100.00",
            false, {}
        ) {}
    }
}
