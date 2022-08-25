package org.kredent.app.ui.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.kredent.core.navigation.GoBack
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.NavigationRequest
import org.kredent.core.utils.parentNavigationObserver
import org.kredent.dashboard.navigation.OpenDetails
import org.kredent.app.R
import org.kredent.app.navigation.NavigationHandler
import org.kredent.app.navigation.action
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TabFragment : Fragment(), NavigationHandler {
    override val navController by lazy {
        val hostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_content_tab)
        (hostFragment as NavHostFragment).navController
    }

    override val parent: NavigationObserver?
        get() = parentNavigationObserver

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBottomNavigation(view)
    }

    private fun setupBottomNavigation(view: View) {
        bottomNavigationView = view.findViewById(R.id.tab_bottom_navigation_view)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        bottomNavigationView.setOnItemReselectedListener { item ->
            val destinationId = when (item.itemId) {
                R.id.dashboardGraph -> org.kredent.dashboard.R.id.dashboardFragment
                R.id.transactionsGraph -> org.kredent.transactions.R.id.transactionsFragment
                R.id.contactGraph -> org.kredent.contact.R.id.contactFragment
                else -> null
            }
            if (destinationId != null) {
                navController.popBackStack(destinationId, inclusive = false)
            }
        }
    }

    /*
     * A hack needed because of current behavior in Bottom Navigation
     * https://gist.github.com/hoc081098/78092f44c3063fe78b34e4cdd3e7e7ad
     */
    override fun onNavigation(request: NavigationRequest): Boolean {
        if (request is GoBack) {
            val id = navController.currentDestination?.id
            if (id == org.kredent.transactions.R.id.transactionsFragment || id == org.kredent.contact.R.id.contactFragment) {
                bottomNavigationView.selectedItemId = bottomNavigationView.menu[0].itemId
                return true
            }
        }
        return super.onNavigation(request)
    }

    override fun getAction(request: NavigationRequest) = when (request) {
        is OpenDetails -> request.action
        else -> null
    }
}
