package org.kredent.dashboard.navigation.details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailsArgs(val name: String, val color: ULong, val onColor: ULong) : Parcelable
