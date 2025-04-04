# Painel Interativo FCT/UFG

![Kotlin](https://img.shields.io/badge/kotlin-1.9.0-blue.svg)
![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-1.8.0-green.svg)
![Plataformas](https://img.shields.io/badge/Plataformas-Android%20%7C%20Desktop-orange)

## 📝 Descrição

O Painel Interativo FCT/UFG é uma aplicação multiplatforma construída com Kotlin e Compose Multiplatform que oferece um ponto central de informações e recursos para a Faculdade de Ciência e Tecnologia da Universidade Federal de Goiás. A aplicação funciona tanto em dispositivos Android quanto em computadores desktop, mantendo uma experiência de usuário consistente em ambas plataformas.

## ✨ Funcionalidades

- **Feed de Notícias**: Exibe as últimas notícias da FCT/UFG, atualizadas automaticamente a cada hora
- **Tour Virtual do Campus**: Apresentação interativa do campus via Prezi
- **Informações de Transporte**: Acesso rápido às linhas de ônibus que servem o campus
- **Horário de Aulas**: Consulta ao horário das disciplinas oferecidas
- **Mapa de Salas**: Localização visual das salas dentro do campus
- **Equipe FCT/UFG**: Painel com informações sobre os colaboradores
- **Ações de Extensão**: Visualização de projetos e ações de extensão da faculdade

## 🛠️ Tecnologias Utilizadas

- **Kotlin Multiplatform**: Base da aplicação, permitindo compartilhar código entre plataformas
- **Compose Multiplatform**: Framework de UI declarativo
- **Material Design**: Design system para interface consistente
- **Ktor**: Cliente HTTP para obtenção de dados da web
- **JavaFX**: Para renderização de WebView no desktop
- **Android WebView**: Para exibição de conteúdo web no Android

## 📱 Suporte a Plataformas

- **Android**: Interface nativa com suporte a tela cheia
- **Desktop**: Aplicação JVM com suporte a Windows, macOS e Linux

## 🚀 Como Executar

### Pré-requisitos

- JDK 11 ou superior
- Android SDK (para build Android)
- Gradle 8.0 ou superior

### Executando no Desktop

```bash
./gradlew :desktop:run
```

### Executando no Android

```bash
./gradlew :android:installDebug
```

### Compilando para distribuição

#### Desktop

```bash
./gradlew :desktop:packageDmg      # para macOS
./gradlew :desktop:packageMsi      # para Windows
./gradlew :desktop:packageDeb      # para Linux
```

#### Android

```bash
./gradlew :android:assembleRelease
```

## 📂 Estrutura do Projeto

```
src
├── androidMain           # Código específico para Android
│   └── kotlin/br.ufg
│       └── MainAndroid.kt
├── desktopMain           # Código específico para Desktop
│   └── kotlin/br.ufg
│       └── MainDesktop.kt
└── commonMain            # Código compartilhado entre plataformas
    └── kotlin/br.ufg
        └── MainScreen.kt
```

## 🔄 Arquitetura

A aplicação segue uma arquitetura que maximiza o compartilhamento de código entre plataformas:

- **Lógica de UI**: Compartilhada através do Compose Multiplatform
- **Componentes Específicos**: Implementações específicas para cada plataforma (como WebView)
- **Lógica de Negócio**: Totalmente compartilhada via código comum

## 📄 Recursos Externos

A aplicação consume os seguintes recursos externos:
- Feed RSS da FCT/UFG (https://fct.ufg.br/feed)
- Apresentações do Prezi
- Power BI para visualização de dados
- Páginas web específicas da FCT/UFG

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
