package org.kredent.designkit.palette

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.theme.KredentTheme
import org.kredent.designkit.theme.spacing

@Composable
fun ProgressButton(
    loading: Boolean,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .animateContentSize()
                .height(ButtonDefaults.MinHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)
        ) {
            Text(text = text)
            if (loading) {
                CircularProgressIndicator(
                    strokeWidth = MaterialTheme.spacing.mini,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(MaterialTheme.spacing.big)
                )
            }
        }
    }
}

@CombinedPreviews
@Composable
fun SecondLevelAuthenticationScreenPreview() {
    KredentTheme {
        var loading by remember { mutableStateOf(false) }
        ProgressButton(loading = loading, text = "FooBar") { loading = !loading }
    }
}
