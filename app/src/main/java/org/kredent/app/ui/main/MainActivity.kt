package org.kredent.app.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import co.touchlab.kermit.Logger
import com.google.android.material.color.DynamicColors
import org.kredent.common.navigation.StartNewTransfer
import org.kredent.common.navigation.StartSecondLevelAuthentication
import org.kredent.core.navigation.NavigationObserver
import org.kredent.core.navigation.NavigationRequest
import org.kredent.core.navigation.observe
import org.kredent.core.utils.getColorFromAttr
import org.kredent.app.R
import org.kredent.app.navigation.*
import org.kredent.login.navigation.LoginSuccessful
import org.kredent.transfer.navigation.OpenTransferAmount
import org.kredent.transfer.navigation.OpenTransferSummary
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationHandler {
    private val viewModel: MainViewModel by viewModels()
    private var graphSet = false

    override val navController: NavController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_content_main
        ) as NavHostFragment
        navHostFragment.navController
    }
    override val parent: NavigationObserver?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        graphSet = savedInstanceState?.getBoolean(GRAPH_SET_KEY) ?: false

        DynamicColors.applyToActivityIfAvailable(this)
        setContentView(R.layout.activity_main)

        // We need to manually set the window's background due to a limitation in Splash's API.
        window.decorView.setBackgroundColor(getColorFromAttr(android.R.attr.colorBackground))
        splashScreen.setKeepOnScreenCondition() { !graphSet }

        // Handle Global Navigation Requests
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                observe(viewModel)
            }
        }
        observeState()

        if (graphSet) {
            // If we already setup the graph once we have its state handled by the framework
            // so we just need to inflate an empty graph
            navController.graph = navController.navInflater.inflate(R.navigation.main_graph)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(GRAPH_SET_KEY, graphSet)
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.initGraph
                    .collect { graphId ->
                        Logger.i { "Changing NavGraph to $graphId" }
                        navController.graph =
                            navController.navInflater.inflate(R.navigation.main_graph)
                                .apply { setStartDestination(graphId) }
                        graphSet = true
                        viewModel.graphSetupFinished()
                    }
            }
        }
    }

    override fun getAction(request: NavigationRequest) = when (request) {
        is LoginSuccessful -> request.action
        is StartSecondLevelAuthentication -> request.action
        is StartNewTransfer -> request.action
        is OpenTransferAmount -> request.action
        is OpenTransferSummary -> request.action
        is ToLogin -> request.action
        is ToTab -> request.action
        is ToToken -> request.action
        else -> null
    }

    companion object {
        const val GRAPH_SET_KEY = "GRAPH_SET_KEY"
    }
}
