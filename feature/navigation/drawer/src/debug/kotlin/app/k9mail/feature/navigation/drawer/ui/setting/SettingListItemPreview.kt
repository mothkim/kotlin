package app.k9mail.feature.navigation.drawer.ui.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.k9mail.core.ui.compose.designsystem.PreviewWithThemes
import app.k9mail.core.ui.compose.designsystem.atom.icon.Icons

@Composable
@Preview(showBackground = true)
internal fun SettingListItemPreview() {
    PreviewWithThemes {
        SettingListItem(
            label = "Settings",
            onClick = {},
            imageVector = Icons.Outlined.Settings,
        )
    }
}
