package org.kredent.transfer.navigation.summary

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransferSummaryArgs(
    val name: String,
    val account: String,
    val message: String,
    val amount: String
) : Parcelable
