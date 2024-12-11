package app.k9mail.feature.migration.qrcode.ui

import android.net.Uri
import app.k9mail.core.ui.compose.common.mvi.UnidirectionalViewModel
import app.k9mail.feature.migration.qrcode.domain.QrCodeDomainContract.UseCase

internal interface QrCodeScannerContract {
    interface ViewModel : UnidirectionalViewModel<State, Event, Effect> {
        val cameraUseCasesProvider: UseCase.CameraUseCasesProvider
    }

    data class State(
        val cameraPermissionState: UiPermissionState = UiPermissionState.Unknown,
        val displayText: DisplayText = DisplayText.HelpText,
    )

    sealed interface Event {
        data object StartScreen : Event
        data class CameraPermissionResult(val success: Boolean) : Event
        data object GoToSettingsClicked : Event
        data object ReturnedFromAppInfoScreen : Event
        data object DoneClicked : Event
    }

    sealed interface Effect {
        data object RequestCameraPermission : Effect
        data object GoToAppInfoScreen : Effect
        data class ReturnResult(val contentUri: Uri) : Effect
        data object Cancel : Effect
    }

    enum class UiPermissionState {
        Unknown,
        Granted,
        Denied,
        Waiting,
    }

    sealed interface DisplayText {
        data object HelpText : DisplayText
        data class ProgressText(val scannedCount: Int, val totalCount: Int) : DisplayText
    }
}
