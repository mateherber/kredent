package org.kredent.designkit.palette

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.theme.KredentTheme
import org.kredent.designkit.theme.spacing

@Composable
fun Palette(modifier: Modifier = Modifier, onClick: (String, ULong, ULong) -> Unit) {
    val items = listOf(
        "primary" to (MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.onPrimary),
        "onPrimary" to (MaterialTheme.colorScheme.onPrimary to MaterialTheme.colorScheme.primary),
        "inversePrimary" to (MaterialTheme.colorScheme.inversePrimary to MaterialTheme.colorScheme.primary),
        "primaryContainer" to (MaterialTheme.colorScheme.primaryContainer to MaterialTheme.colorScheme.onPrimaryContainer),
        "onPrimaryContainer" to (MaterialTheme.colorScheme.onPrimaryContainer to MaterialTheme.colorScheme.primaryContainer),
        "secondary" to (MaterialTheme.colorScheme.secondary to MaterialTheme.colorScheme.onSecondary),
        "onSecondary" to (MaterialTheme.colorScheme.onSecondary to MaterialTheme.colorScheme.secondary),
        "secondaryContainer" to (MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer),
        "onSecondaryContainer" to (MaterialTheme.colorScheme.onSecondaryContainer to MaterialTheme.colorScheme.secondaryContainer),
        "tertiary" to (MaterialTheme.colorScheme.tertiary to MaterialTheme.colorScheme.onTertiary),
        "onTertiary" to (MaterialTheme.colorScheme.onTertiary to MaterialTheme.colorScheme.tertiary),
        "tertiaryContainer" to (MaterialTheme.colorScheme.tertiaryContainer to MaterialTheme.colorScheme.onTertiaryContainer),
        "onTertiaryContainer" to (MaterialTheme.colorScheme.onTertiaryContainer to MaterialTheme.colorScheme.tertiaryContainer),
        "background" to (MaterialTheme.colorScheme.background to MaterialTheme.colorScheme.onBackground),
        "onBackground" to (MaterialTheme.colorScheme.onBackground to MaterialTheme.colorScheme.background),
        "error" to (MaterialTheme.colorScheme.error to MaterialTheme.colorScheme.onError),
        "onError" to (MaterialTheme.colorScheme.onError to MaterialTheme.colorScheme.error),
        "errorContainer" to (MaterialTheme.colorScheme.errorContainer to MaterialTheme.colorScheme.onErrorContainer),
        "onErrorContainer" to (MaterialTheme.colorScheme.onErrorContainer to MaterialTheme.colorScheme.errorContainer),
        "surface" to (MaterialTheme.colorScheme.surface to MaterialTheme.colorScheme.onSurface),
        "onSurface" to (MaterialTheme.colorScheme.onSurface to MaterialTheme.colorScheme.surface),
        "inverseSurface" to (MaterialTheme.colorScheme.inverseSurface to MaterialTheme.colorScheme.surface),
        "surfaceVariant" to (MaterialTheme.colorScheme.surfaceVariant to MaterialTheme.colorScheme.onSurfaceVariant),
        "onSurfaceVariant" to (MaterialTheme.colorScheme.onSurfaceVariant to MaterialTheme.colorScheme.surfaceVariant),
        "surfaceTint" to (MaterialTheme.colorScheme.surfaceTint to MaterialTheme.colorScheme.surface),
        "outline" to (MaterialTheme.colorScheme.outline to MaterialTheme.colorScheme.onPrimary),
    )
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.default),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.spacing.default,
            vertical = MaterialTheme.spacing.default
        ),
    ) {
        items(items) { (name, color) ->
            Box(
                modifier = Modifier
                    .clickable { onClick(name, color.first.value, color.second.value) }
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(color.first)
                    .padding(MaterialTheme.spacing.default)
            ) {
                Text(
                    text = name,
                    modifier = Modifier.align(Alignment.Center),
                    color = color.second,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@CombinedPreviews
@Composable
fun PalettePreview() {
    KredentTheme {
        Palette(onClick = { _, _, _ -> })
    }
}

