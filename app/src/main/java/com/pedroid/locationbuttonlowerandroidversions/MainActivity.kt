package com.pedroid.locationbuttonlowerandroidversions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.locationbutton.compose.LocationButton
import androidx.core.locationbutton.compose.LocationButtonTextType
import com.pedroid.locationbuttonlowerandroidversions.ui.theme.LocationButtonLowerAndroidVersionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocationButtonLowerAndroidVersionsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScenarioList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
private fun ScenarioList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        item {
            Text(
                text = "LocationButton (Compose) — size / padding / corner-radius matrix.\n" +
                    "Run this app on an Android 17 device and on an older version, then compare screenshots.\n" +
                    "The grey box behind each button traces its exact bounds — any grey visible through " +
                    "the rounded background reveals a corner-radius or padding rendering bug.",
                modifier = Modifier.padding(vertical = 16.dp),
            )
        }
        items(buttonScenarios) { scenario ->
            ScenarioRow(scenario)
        }
    }
}

@Composable
private fun ScenarioRow(scenario: ButtonScenario) {
    Column {
        Text(text = scenario.label, modifier = Modifier.padding(bottom = 6.dp))

        var boxModifier: Modifier = Modifier
        scenario.widthDp?.let { boxModifier = boxModifier.width(it.dp) }
        scenario.heightDp?.let { boxModifier = boxModifier.height(it.dp) }

        Box(
            modifier = boxModifier.background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center,
        ) {
            // Separate call sites so a null cornerRadius is never forwarded, letting the
            // library apply its own default instead of an explicit Dp.Unspecified.
            if (scenario.cornerRadiusDp != null) {
                LocationButton(
                    onPermissionResult = {},
                    textType = LocationButtonTextType.PreciseLocation,
                    cornerRadius = scenario.cornerRadiusDp.dp,
                    clickablePadding = PaddingValues(scenario.paddingDp.dp),
                )
            } else {
                LocationButton(
                    onPermissionResult = {},
                    textType = LocationButtonTextType.PreciseLocation,
                    clickablePadding = PaddingValues(scenario.paddingDp.dp),
                )
            }
        }
    }
}
