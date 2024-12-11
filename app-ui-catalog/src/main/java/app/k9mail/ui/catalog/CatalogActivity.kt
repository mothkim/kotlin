package app.k9mail.ui.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import app.k9mail.core.ui.compose.common.activity.setActivityContent
import app.k9mail.ui.catalog.ui.CatalogScreen

class CatalogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)

        setActivityContent {
            CatalogScreen()
        }
    }
}
