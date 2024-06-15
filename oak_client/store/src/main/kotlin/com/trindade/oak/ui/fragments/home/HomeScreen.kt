package com.trindade.oak.ui.fragments.home

import android.content.*

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

import com.trindade.oak.R
import com.trindade.oak.data.*
import com.trindade.oak.ui.theme.*
import com.trindade.oak.data.models.*
import com.trindade.oak.ui.models.toolbar.*
import com.trindade.oak.ui.fragments.home.lists.*
import com.trindade.oak.ui.fragments.details.*

@Composable
fun HomeScreen(context: Context) {
    OakTheme {
        HomeContent(context)
    }
}

@Composable
private fun HomeContent(context: Context) {
    val context = context.applicationContext
    val (apps, setApps) = remember { mutableStateOf<List<ProjectModel>?>(null) }
    val (error, setError) = remember { mutableStateOf<String?>(null) }
    val dataRepo = DataRepository(context)

    LaunchedEffect(Unit) {
        dataRepo.getData(context.getString(R.string.API_URL), "GET", object : DataCallback {
            override fun onDataReceived(response: List<ProjectModel>) {
                setApps(response)
            }

            override fun onError(message: String) {
                setError(message)
            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        topAppBarLarge(
           title = "Oak Store"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            if (apps != null) {
                AppsList(apps)
            } else if (error != null) {
                Text (
                    text = error,
                    color = MaterialTheme.colorScheme.error
                )
            } else {
                CircularProgressIndicator()
            }
        }
    }
}