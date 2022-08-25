package org.kredent.transfer.ui.amount

import androidx.fragment.app.viewModels
import org.kredent.core.ui.CoordinatedFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransferAmountFragment :
    CoordinatedFragment<TransferAmountCoordinator, TransferAmountViewModel>() {
    override val viewModel by viewModels<TransferAmountViewModel>()

    override fun onCreateView() = kredentView {
        TransferAmountScreen(viewModel)
    }
}
