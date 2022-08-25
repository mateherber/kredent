package org.kredent.transfer.ui.form

import androidx.fragment.app.viewModels
import org.kredent.core.ui.CoordinatedFragment
import org.kredent.designkit.common.kredentView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransferFormFragment : CoordinatedFragment<TransferFormCoordinator, TransferFormViewModel>() {
    override val viewModel by viewModels<TransferFormViewModel>()

    override fun onCreateView() = kredentView {
        TransferFormScreen(viewModel)
    }
}
