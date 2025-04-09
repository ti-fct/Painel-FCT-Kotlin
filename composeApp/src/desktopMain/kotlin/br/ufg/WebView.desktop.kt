// composeApp/src/desktopMain/kotlin/br.ufg/WebView.desktop.kt
package br.ufg

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView // Importação da biblioteca
import com.multiplatform.webview.web.rememberWebViewState // Importação para gerenciar o estado

@Composable
actual fun WebView(url: String, modifier: Modifier) {
    // Cria e lembra o estado do WebView, inicializando com a URL desejada.
    // O estado gerencia a URL atual, o estado de carregamento, navegação, etc.
    val webViewState = rememberWebViewState(url = url)

    // Utiliza o componente WebView fornecido pela biblioteca.
    WebView(
        state = webViewState, // Passa o estado para controlar o WebView.
        modifier = modifier, // Aplica os modificadores do Compose (layout, etc.).
        // O lambda onCreated é chamado após a criação da instância do WebView nativo.
        // Para configurações básicas, geralmente não é necessário adicionar código aqui,
        // pois a biblioteca configura padrões razoáveis.
        // Configurações mais avançadas ou específicas da plataforma poderiam ser feitas aqui,
        // se a API da biblioteca permitir acesso direto.
    )
}