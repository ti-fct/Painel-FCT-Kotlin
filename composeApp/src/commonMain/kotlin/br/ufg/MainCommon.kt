// composeApp/src/commonMain/kotlin/br.ufg/MainCommon.kt
package br.ufg

import androidx.compose.runtime.Composable
import br.ufg.navigation.Screen
import br.ufg.navigation.rememberNavigationState
import br.ufg.theme.FCTUFGTheme
import br.ufg.ui.HomeScreen

@Composable
fun App() {
    FCTUFGTheme {
        val navigationState = rememberNavigationState()

        when (navigationState.currentScreen) {
            Screen.HOME -> HomeScreen(
                onNavigateToWebView = { url, title ->
                    navigationState.navigateToWebView(url, title)
                }
            )
            Screen.WEB_VIEW -> WebViewScreen(
                url = navigationState.webViewData.url,
                title = navigationState.webViewData.title,
                onBackClick = {
                    navigationState.navigateToHome()
                }
            )
        }
    }
}