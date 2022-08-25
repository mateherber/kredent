package org.kredent.designkit.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.kredent.designkit.theme.KredentTheme

inline fun Fragment.kredentView(crossinline block: @Composable () -> Unit): ComposeView {
    return ComposeView(requireActivity()).apply {
        setContent {
            KredentTheme { block() }
        }
    }
}
