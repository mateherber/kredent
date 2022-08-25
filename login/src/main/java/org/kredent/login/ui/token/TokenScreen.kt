package org.kredent.login.ui.token

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview

@Composable
fun TokenScreen(viewModel: TokenViewModel) {
    TokenScreen(viewModel::createToken)
}

@Composable
private fun TokenScreen(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = onClick
        ) {
            Text("Create Token")
        }
    }
}

@CombinedPreviews
@Composable
fun TokenScreenPreview() {
    KredentPreview {
        TokenScreen {}
    }
}
