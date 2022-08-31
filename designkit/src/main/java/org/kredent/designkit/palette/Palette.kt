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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.kredent.designkit.common.CombinedPreviews
import org.kredent.designkit.theme.KredentTheme
import org.kredent.designkit.theme.spacing

@Composable
fun Palette(modifier: Modifier = Modifier, onClick: (String, ULong, ULong) -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    val items by remember(colorScheme) {
        mutableStateOf(
            listOf(
                "primary" to (colorScheme.primary to colorScheme.onPrimary),
                "onPrimary" to (colorScheme.onPrimary to colorScheme.primary),
                "inversePrimary" to (colorScheme.inversePrimary to colorScheme.primary),
                "primaryContainer" to (colorScheme.primaryContainer to colorScheme.onPrimaryContainer),
                "onPrimaryContainer" to (colorScheme.onPrimaryContainer to colorScheme.primaryContainer),
                "secondary" to (colorScheme.secondary to colorScheme.onSecondary),
                "onSecondary" to (colorScheme.onSecondary to colorScheme.secondary),
                "secondaryContainer" to (colorScheme.secondaryContainer to colorScheme.onSecondaryContainer),
                "onSecondaryContainer" to (colorScheme.onSecondaryContainer to colorScheme.secondaryContainer),
                "tertiary" to (colorScheme.tertiary to colorScheme.onTertiary),
                "onTertiary" to (colorScheme.onTertiary to colorScheme.tertiary),
                "tertiaryContainer" to (colorScheme.tertiaryContainer to colorScheme.onTertiaryContainer),
                "onTertiaryContainer" to (colorScheme.onTertiaryContainer to colorScheme.tertiaryContainer),
                "background" to (colorScheme.background to colorScheme.onBackground),
                "onBackground" to (colorScheme.onBackground to colorScheme.background),
                "error" to (colorScheme.error to colorScheme.onError),
                "onError" to (colorScheme.onError to colorScheme.error),
                "errorContainer" to (colorScheme.errorContainer to colorScheme.onErrorContainer),
                "onErrorContainer" to (colorScheme.onErrorContainer to colorScheme.errorContainer),
                "surface" to (colorScheme.surface to colorScheme.onSurface),
                "onSurface" to (colorScheme.onSurface to colorScheme.surface),
                "inverseSurface" to (colorScheme.inverseSurface to colorScheme.surface),
                "surfaceVariant" to (colorScheme.surfaceVariant to colorScheme.onSurfaceVariant),
                "onSurfaceVariant" to (colorScheme.onSurfaceVariant to colorScheme.surfaceVariant),
                "surfaceTint" to (colorScheme.surfaceTint to colorScheme.surface),
                "outline" to (colorScheme.outline to colorScheme.onPrimary),
            )
        )
    }
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

