package com.github.shenziq1.navigationTemplate.screens.homeScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.github.shenziq1.navigationTemplate.Screen
import com.github.shenziq1.navigationTemplate.models.HomeGameTabCard
import com.github.shenziq1.navigationTemplate.uiStates.CardUiState
import kotlinx.coroutines.flow.StateFlow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeGameTabCardView(homeGameTabCard: HomeGameTabCard, navController: NavHostController) {
    Card(onClick = {
        navController.navigate(
            route = Screen.Detail.passNameId(
                homeGameTabCard.id,
                homeGameTabCard.name
            )
        )
    }) {
        Row() {
            Text(text = "${homeGameTabCard.id.toString()}:", fontSize = 80.sp)
            Spacer(modifier = Modifier.width(60.dp))
            Text(text = homeGameTabCard.counter.toString(), fontSize = 80.sp)
        }
    }
}