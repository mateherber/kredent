package org.kredent.transfer.navigation.amount

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransferAmountArgs(val name: String, val account: String) : Parcelable
