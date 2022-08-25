package org.kredent.dashboard.ui.dashboard

import androidx.lifecycle.ViewModel
import org.kredent.core.navigation.NavigationSource
import org.kredent.dashboard.navigation.OpenDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val navigationSource: NavigationSource
) : ViewModel(), NavigationSource by navigationSource {
    fun detailRequested(name: String, color: ULong, onColor: ULong) {
        navigate(OpenDetails(name, color, onColor))
    }
}
