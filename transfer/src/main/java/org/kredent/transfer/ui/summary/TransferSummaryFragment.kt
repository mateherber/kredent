package org.kredent.transfer.ui.summary

import androidx.fragment.app.viewModels
import org.kredent.core.ui.CoordinatedFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransferSummaryFragment :
    CoordinatedFragment<TransferSummaryCoordinator, TransferSummaryViewModel>() {
    override val viewModel by viewModels<TransferSummaryViewModel>()

    override fun onCreateView() = kredentView {
        TransferSummaryScreen(viewModel)
    }
}
