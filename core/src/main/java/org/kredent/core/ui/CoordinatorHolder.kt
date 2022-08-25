package org.kredent.core.ui

import javax.inject.Inject

class CoordinatorHolder<T : Any> @Inject constructor() : CoordinatedViewModel<T> {
    override lateinit var coordinator: T
        private set

    override fun attach(coordinator: T) {
        this.coordinator = coordinator
    }
}
