package org.kredent.dashboard.ui.dashboard

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.common.KredentPreview
import org.kredent.designkit.palette.Palette

@Composable
fun DashboardScreen(viewModel: DashboardViewModel) {
    DashboardScreen(viewModel::detailRequested)
}

@Composable
private fun DashboardScreen(onColorSelect: (String, ULong, ULong) -> Unit) {
    Palette(modifier = Modifier.statusBarsPadding(), onClick = onColorSelect)
}

@CombinedPreviews
@Composable
fun DashboardScreenPreview() {
    KredentPreview {
        DashboardScreen { _, _, _ -> }
    }
}
