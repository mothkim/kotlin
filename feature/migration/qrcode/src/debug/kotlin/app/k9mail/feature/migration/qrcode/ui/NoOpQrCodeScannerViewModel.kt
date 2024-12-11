package app.k9mail.feature.migration.qrcode.ui

import app.k9mail.core.ui.compose.common.mvi.BaseViewModel
import app.k9mail.feature.migration.qrcode.domain.QrCodeDomainContract.UseCase
import app.k9mail.feature.migration.qrcode.ui.QrCodeScannerContract.Effect
import app.k9mail.feature.migration.qrcode.ui.QrCodeScannerContract.Event
import app.k9mail.feature.migration.qrcode.ui.QrCodeScannerContract.State

internal class NoOpQrCodeScannerViewModel(
    initialState: State = State(),
) : BaseViewModel<State, Event, Effect>(initialState), QrCodeScannerContract.ViewModel {
    override val cameraUseCasesProvider = UseCase.CameraUseCasesProvider { emptyList() }

    override fun event(event: Event) = Unit
}
