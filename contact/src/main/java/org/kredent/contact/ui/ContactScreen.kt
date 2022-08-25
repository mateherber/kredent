package org.kredent.contact.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview
import org.kredent.designkit.theme.spacing

@Composable
fun ContactScreen(viewModel: ContactViewModel) {
    ContactScreen(viewModel::logout)
}

@Composable
private fun ContactScreen(onLogoutClick: () -> Unit) {
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
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onLogoutClick
        ) {
            Text("Logout")
        }
    }
}

@CombinedPreviews
@Composable
fun ContactScreenPreview() {
    KredentPreview {
        ContactScreen {}
    }
}
