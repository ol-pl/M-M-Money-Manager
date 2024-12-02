package com.olpl.settings_presentation.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.olpl.core_presentation.components.TopAppBarImpl
import com.olpl.settings_presentation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingsTopAppBar() {
    TopAppBarImpl(
        title = R.string.screen_title,
        navigationIcon = {
            IconButton(
                onClick = {},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "settings back button",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    )
}