package app.k9mail.feature.navigation.drawer.ui.account

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.k9mail.core.ui.compose.designsystem.PreviewWithTheme
import app.k9mail.feature.navigation.drawer.ui.FakeData.DISPLAY_ACCOUNT
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview(showBackground = true)
internal fun AccountListPreview() {
    PreviewWithTheme {
        AccountList(
            accounts = persistentListOf(
                DISPLAY_ACCOUNT,
            ),
            selectedAccount = null,
            onAccountClick = { },
            onSettingsClick = { },
            onSyncAllAccountsClick = { },
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun AccountListWithSelectedPreview() {
    PreviewWithTheme {
        AccountList(
            accounts = persistentListOf(
                DISPLAY_ACCOUNT,
            ),
            selectedAccount = DISPLAY_ACCOUNT,
            onAccountClick = { },
            onSettingsClick = { },
            onSyncAllAccountsClick = { },
        )
    }
}
