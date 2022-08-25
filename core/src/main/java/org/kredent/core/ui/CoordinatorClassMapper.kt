package org.kredent.core.ui

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel

interface CoordinatorClassMapper {
    fun getCoordinatorClass(@IdRes graphId: Int): Class<out ViewModel>?
}
