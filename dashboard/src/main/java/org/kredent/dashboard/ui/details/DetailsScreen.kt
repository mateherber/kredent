package org.kredent.dashboard.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.kredent.dashboard.navigation.details.DetailsArgs
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview

@Composable
fun DetailsScreen(args: DetailsArgs) {
    DetailsScreen(args.name, args.color, args.onColor)
}

@Composable
private fun DetailsScreen(name: String, color: ULong, onColor: ULong) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(color)),
        contentAlignment = Alignment.Center
    ) {
        Text(name, color = Color(onColor))
    }
}

@CombinedPreviews
@Composable
fun DetailsScreenPreview() {
    KredentPreview {
        DetailsScreen("primary", Color(0xFF006C47).value, Color(0xFFFFFFFF).value)
    }
}
