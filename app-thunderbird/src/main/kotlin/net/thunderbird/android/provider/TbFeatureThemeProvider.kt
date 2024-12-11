package net.thunderbird.android.provider

import androidx.compose.runtime.Composable
import app.k9mail.core.ui.compose.theme2.thunderbird.ThunderbirdTheme2
import app.k9mail.core.ui.theme.api.FeatureThemeProvider

class TbFeatureThemeProvider : FeatureThemeProvider {
    @Composable
    override fun WithTheme(content: @Composable () -> Unit) {
        ThunderbirdTheme2 {
            content()
        }
    }

    @Composable
    override fun WithTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
        ThunderbirdTheme2(darkTheme = darkTheme) {
            content()
        }
    }
}
