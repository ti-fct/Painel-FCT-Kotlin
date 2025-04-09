// composeApp/src/commonMain/kotlin/br.ufg/ui/HomeScreen.kt
package br.ufg.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.ufg.model.MenuItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToWebView: (String, String) -> Unit) {
    val menuItems = remember {
        listOf(
            MenuItem(
                id = "home",
                title = "Página Inicial",
                icon = Icons.Filled.Home,
                description = "Voltar para a tela inicial"
            ) {
                onNavigateToWebView("https://fct.ufg.br", "Página Inicial")
            },

            MenuItem(
                id = "campus",
                title = "Conheça o Campus",
                icon = Icons.Filled.LocationCity,
                description = "Explore as instalações da FCT/UFG"
            ) {
                onNavigateToWebView("https://prezi.com/view/MZjulFdzyMstq9zoDLVX/", "Conheça o Campus")
            },

            MenuItem(
                id = "sigaa",
                title = "SIGAA",
                icon = Icons.Filled.School,
                description = "Acesse o sistema acadêmico"
            ) {
                onNavigateToWebView("https://sigaa.sistemas.ufg.br/sigaa/mobile/", "SIGAA")
            },

            MenuItem(
                id = "bus",
                title = "Linha de Ônibus",
                icon = Icons.Filled.DirectionsBus,
                description = "Consulte horários e rotas"
            ) {
                onNavigateToWebView("https://rmtcgoiania.com.br/index.php/linhas-e-trajetos/area-sul?buscar=555", "Linha de Ônibus")
            },

            MenuItem(
                id = "schedule",
                title = "Horários de Aulas",
                icon = Icons.Filled.Schedule,
                description = "Consulte os horários de aulas"
            ) {
                onNavigateToWebView("https://ti-fct.github.io/horariosFCT/", "Horários de Aulas")
            },

            MenuItem(
                id = "rooms",
                title = "Mapa de Salas",
                icon = Icons.Filled.Map,
                description = "Encontre salas de aula e laboratórios"
            ) {
                onNavigateToWebView("https://docs.google.com/gview?embedded=true&url=https://ti-fct.github.io/Painel-FCT/mapa.pdf", "Mapa de Salas")
            },

            MenuItem(
                id = "team",
                title = "Equipe FCT/UFG",
                icon = Icons.Filled.Group,
                description = "Conheça professores e servidores"
            ) {
                onNavigateToWebView("https://app.powerbi.com/view?r=eyJrIjoiNjUzMDMzOWUtNzViNS00NGYyLTk1YTYtMWY5MWE5OGI1YzAzIiwidCI6ImIxY2E3YTgxLWFiZjgtNDJlNS05OGM2LWYyZjJhOTMwYmEzNiJ9", "Equipe FCT/UFG")
            },

            MenuItem(
                id = "extension",
                title = "Ações de Extensão",
                icon = Icons.Filled.Forest,
                description = "Projetos e ações de extensão"
            ) {
                onNavigateToWebView("https://app.powerbi.com/view?r=eyJrIjoiMDcyZWQ2NWMtZTVkMy00YzMyLTkyYjQtNzFmMjQ1MzVjZDcwIiwidCI6ImIxY2E3YTgxLWFiZjgtNDJlNS05OGM2LWYyZjJhOTMwYmEzNiJ9", "Ações de Extensão")
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Painel FCT/UFG")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Grid de cards para o menu
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 300.dp),
                contentPadding = PaddingValues(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(menuItems) { item ->
                    MenuCard(menuItem = item)
                }
            }
        }
    }
}