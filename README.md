# Painel Interativo FCT/UFG

![FCT](https://img.shields.io/badge/Faculdade%20de%20Ciência%20e%20Tecnologia-FCT/UFG-blue.svg)
![Kotlin](https://img.shields.io/badge/kotlin-2.1.10-fuchsia.svg)
![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.7.3-green.svg)
![Plataformas](https://img.shields.io/badge/Plataformas-Android%20%7C%20Desktop-orange)

Um aplicativo multiplataforma (Android e Desktop) desenvolvido com Kotlin Multiplatform e Compose Multiplatform. Ele serve como um painel interativo para a Faculdade de Ciência e Tecnologia (FCT) da UFG, fornecendo acesso rápido a informações e serviços relevantes para estudantes, professores e visitantes.

## ✨ Funcionalidades Principais

* **Acesso Rápido a Links Úteis:** Menu principal com botões para acessar rapidamente:
    * Página inicial da FCT/UFG
    * Tour virtual pelo campus
    * SIGAA (Sistema Integrado de Gestão de Atividades Acadêmicas) - versão mobile
    * Informações sobre a linha de ônibus que atende o campus
    * Horários de aulas
    * Mapa das salas de aula e laboratórios
    * Informações sobre a equipe da FCT (professores e servidores)
    * Detalhes sobre as ações de extensão da faculdade
* **Interface Nativa:** Utiliza Compose Multiplatform para criar uma interface de usuário fluida e consistente em ambas as plataformas (Android e Desktop).
* **Visualização Integrada:** Abre os links externos dentro de um componente `WebView` integrado ao aplicativo, mantendo o usuário no contexto da aplicação.
* **Navegação Simples:** Sistema de navegação básico entre a tela inicial (menu) e a tela de visualização web.
* **Tema Dinâmico:** Suporte a temas claro e escuro, adaptando-se às preferências do sistema.

## 🚀 Tecnologias Utilizadas

* **Kotlin Multiplatform (KMP):** Permite compartilhar código Kotlin entre diferentes plataformas (Android, Desktop, iOS, Web, etc.).
* **Compose Multiplatform:** Framework de UI declarativo moderno do Jetpack Compose adaptado para KMP, permitindo criar interfaces de usuário compartilhadas.
* **Kotlin Coroutines:** Para gerenciamento de operações assíncronas.
* **Material 3:** Biblioteca de componentes de UI seguindo as diretrizes do Material Design 3.
* **Gradle Kotlin DSL:** Sistema de build para gerenciar dependências e configurar o projeto multiplataforma.
* **WebView:**
    * **Android:** Utiliza o `WebView` nativo do Android via `AndroidView` interop.
    * **Desktop:** Utiliza a biblioteca `compose-webview-multiplatform` de terceiros para renderizar conteúdo web no Desktop.
* **State Management:** Gerenciamento de estado simples para navegação usando `mutableStateOf` do Compose Runtime.

* Obs.: * A escolha do KMP/Compose se deu pela integração direta com as plataformas desejadas (Android/Desktop) e suporte nativo.
Alem a necessidade de usar uma WebView, que é um componente nativo complexo. O mecanismo expect/actual do KMP oferece uma maneira limpa e direta de acessar e controlar APIs específicas da plataforma, que é mais seguro e flexível do que depender exclusivamente de um plugin (como o webview_flutter).
Se houvesse uma forte necessidade imediata de iOS/Web maduro ou uma preferência pela abordagem de UI 100% consistente o Flutter/Dart poderia ser considerado.

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Kotlin Multiplatform com Compose:

* `composeApp/`
    * `src/`
        * `commonMain/kotlin/br/ufg/`: Código compartilhado entre todas as plataformas.
            * `model/`: Modelos de dados (ex: `MenuItem`).
            * `navigation/`: Lógica de navegação (`Screen`, `NavigationState`).
            * `theme/`: Definição do tema da aplicação (`FCTUFGTheme`, cores).
            * `ui/`: Componentes de UI compartilhados (`HomeScreen`, `MenuCard`).
            * `MainCommon.kt`: Composable `App()` principal que define a estrutura da UI e a lógica de roteamento.
            * `WebViewScreen.kt`: Tela que encapsula o componente `WebView`.
            * `expect fun WebView(...)`: Declaração `expect` para a funcionalidade `WebView` que precisa ser implementada por cada plataforma.
        * `androidMain/kotlin/br/ufg/`: Código específico para a plataforma Android.
            * `MainActivity.kt`: Ponto de entrada (`Activity`) da aplicação Android.
            * `actual fun WebView(...)`: Implementação (`actual`) do `WebView` usando o `WebView` nativo do Android.
            * `MainAndroid.kt`: Função `main` e `@Preview` para o Android.
        * `desktopMain/kotlin/br/ufg/`: Código específico para a plataforma Desktop (JVM).
            * `MainDesktop.kt`: Ponto de entrada da aplicação Desktop, configura a janela.
            * `actual fun WebView(...)`: Implementação (`actual`) do `WebView` usando a biblioteca `compose-webview-multiplatform`.
* `build.gradle.kts`: Arquivo de configuração do build do Gradle, onde as dependências, plugins e configurações das plataformas (Android, Desktop) são definidos.

## 🛠️ Configuração e Build

1.  **Pré-requisitos:**
    * JDK 17 ou superior.
    * IntelliJ IDEA ou Android Studio (versão recente com suporte a KMP).
    * Android SDK (para compilar e executar no Android).
2.  **Clonar o Repositório:**
    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd <DIRETORIO_DO_PROJETO>
    ```
3.  **Abrir no IDE:** Abra o projeto no IntelliJ IDEA ou Android Studio.
4.  **Executar:**
    * **Android:** Selecione a configuração `androidApp` e um dispositivo/emulador Android e clique em "Run".
    * **Desktop:** Execute a tarefa Gradle `desktopRun` (pode ser encontrada no painel Gradle do IDE: `composeApp > Tasks > compose desktop > desktopRun`).

## 🔮 Implementações Futuras (Roadmap)

Esta é uma lista de melhorias e novas funcionalidades planejadas para o futuro:

* **Melhorar estrutura de pastas:** Alterar alterar nome e estrutra das pastas do projeto para melhor entendimento.
* **Botão Home:** Alterar o comportamento ou o destino do botão "Página Inicial" para levar diretamente à página principal da FCT (avaliar se o comportamento atual já atende ou se a intenção é outra).
* **Limpeza de Navegação:** Implementar uma forma de limpar o estado da `WebView` (cookies, cache, histórico) ao retornar para a `HomeScreen`. Isso é especialmente importante para deslogar automaticamente o usuário do SIGAA.
* **Botão Voltar:** Aprimorar a funcionalidade do botão "Voltar" na `WebViewScreen`. Idealmente, ele deveria primeiro navegar para trás no histórico da `WebView`, se possível, antes de retornar para a `HomeScreen`, e não fechar a aplicação.
* **Tela Cheia:** Configurar a aplicação (especialmente no Desktop) para rodar em modo de tela cheia total, ideal para uso em painéis físicos.
* **Página de Ônibus:** Investigar alternativas para apresentar as informações de ônibus de forma mais direta dentro do app (ex: parsing do site da RMTC, se permitido, ou uso de alguma API, se existir) em vez de apenas carregar o link externo.
* **Webview Desktop:** Terminar a implementação do webview para desktop.
* **Implementar versões iOS e Web:** Avaliar implantação das versões iOS e web no futuro (07/04/2025 o suporte no KMP está em beta)
* **Design:** Melhorias gerais na interface do usuário:
    * Refinamento da paleta de cores.
    * Seleção/criação de ícones mais representativos.
    * Inclusão da logo oficial da FCT/UFG.
* **Notícias (Modo Ocioso):** Implementar um recurso que busque e exiba notícias relevantes (ex: de um feed RSS/Atom da UFG ou FCT) quando o painel estiver ocioso por um determinado período.

## 🤝 Contribuindo

1. Faça o fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Faça commit das suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Faça push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.

## 📞 Contato

Para mais informações sobre o projeto, entre em contato com a Faculdade de Ciência e Tecnologia da UFG.

---

Desenvolvido com ❤️ para a comunidade acadêmica da FCT/UFG.

---

_Este README foi gerado com base no código fornecido em 07/04/2025._