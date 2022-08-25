package org.kredent.core.ui

interface CoordinatedViewModel<T : Any> {
    val coordinator: T
    fun attach(coordinator: T)
    fun onStart() {}
}

