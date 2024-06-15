package com.trindade.oak.ui.fragments.home.lists

import androidx.navigation.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.activity.compose.*
import androidx.compose.ui.draw.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.*
import androidx.compose.material3.*
import androidx.navigation.compose.*
import androidx.compose.material.icons.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*

import coil.compose.*

import com.trindade.oak.R
import com.trindade.oak.data.models.*

@Composable
fun AppsList(apps: List<ProjectModel>) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp)
    ) {
        items(apps) { app ->
             AppItem(app)
        }
    }
}

@Composable
fun AppItem (app: ProjectModel) {
       Card(
           shape = RoundedCornerShape(20.dp),
           modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 4.dp)
       ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AsyncImage(
                        model = app.photo_app,
                        contentDescription = "App icon",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                             .size(50.dp)
                             .clip(RoundedCornerShape(35.dp))
                    )
                        Spacer(modifier = Modifier.width(8.dp))
                    
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                         Text(
                             text = app.name_app,
                             color = MaterialTheme.colorScheme.primary,
                             style = MaterialTheme.typography.bodyLarge
                         )
                         
                         Text(
                             color = MaterialTheme.colorScheme.onBackground,
                             text = app.dev_name,
                             style = MaterialTheme.typography.bodyMedium
                         )
                    }
                }
            }
       }
      Spacer(modifier = Modifier.height(16.dp))
}