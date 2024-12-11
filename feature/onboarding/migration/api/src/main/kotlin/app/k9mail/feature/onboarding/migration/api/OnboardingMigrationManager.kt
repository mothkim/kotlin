package app.k9mail.feature.onboarding.migration.api

import androidx.compose.runtime.Composable

interface OnboardingMigrationManager {
    fun isFeatureIncluded(): Boolean

    @Composable
    fun OnboardingMigrationScreen(
        onQrCodeScan: () -> Unit,
        onAddAccount: () -> Unit,
        onImport: () -> Unit,
    )
}
