package org.kredent.core.ui

import android.app.Activity
import androidx.annotation.MainThread
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import org.kredent.core.utils.graphId

interface CoordinatedScreen<T : Any, V : CoordinatedViewModel<T>> {
    val coordinator: T
    val viewModel: V
    val navController: NavController
    val coordinatorClassMapper: CoordinatorClassMapper
    val activity: Activity
}

fun <T : Any, V : CoordinatedViewModel<T>> CoordinatedScreen<T, V>.attachCoordinator() {
    viewModel.attach(coordinator)
    viewModel.onStart()
}

@Suppress("UNCHECKED_CAST")
@MainThread
fun <VM : Any> CoordinatedScreen<*, *>.coordinator() = lazy {
    val graphId =
        navController.graphId ?: throw IllegalStateException("Parent navigation graph is not found")
    val backStackEntry = navController.getBackStackEntry(graphId)
    val clazz = coordinatorClassMapper.getCoordinatorClass(graphId)
        ?: throw IllegalStateException("There is no coordinator mapping found for graphId: $graphId")
    ViewModelProvider(backStackEntry, HiltViewModelFactory(activity, backStackEntry))[clazz] as VM
}
