package com.pedroid.locationbuttonlowerandroidversions.views

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.locationbutton.LocationButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val density = resources.displayMetrics.density
        fun dp(value: Float): Int = (value * density).toInt()

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16f))
        }

        root.addView(
            TextView(this).apply {
                text = "LocationButton (Views) — size / padding / corner-radius matrix.\n" +
                    "Run this app on an Android 17 device and on an older version, then compare screenshots.\n" +
                    "The grey box behind each button traces its exact view bounds — any grey visible " +
                    "through the rounded background reveals a corner-radius or padding rendering bug."
                textSize = 13f
                setPadding(0, 0, 0, dp(24f))
            }
        )

        for (scenario in buttonScenarios) {
            root.addView(scenarioRow(scenario, density))
        }

        val scrollView = ScrollView(this).apply { addView(root) }
        setContentView(scrollView)

        ViewCompat.setOnApplyWindowInsetsListener(scrollView) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
    }

    private fun scenarioRow(scenario: ButtonScenario, density: Float): LinearLayout {
        fun dp(value: Float): Int = (value * density).toInt()

        val label = TextView(this).apply {
            text = scenario.label
            textSize = 13f
            setPadding(0, 0, 0, dp(6f))
        }

        val button = LocationButton(this).apply {
            setPadding(dp(scenario.paddingDp))
            scenario.cornerRadiusDp?.let { setCornerRadius(dp(it).toFloat()) }
        }

        val buttonContainer = FrameLayout(this).apply {
            setBackgroundColor(Color.parseColor("#FFE0E0E0"))
            addView(
                button,
                FrameLayout.LayoutParams(
                    scenario.widthDp?.let { dp(it) } ?: FrameLayout.LayoutParams.WRAP_CONTENT,
                    scenario.heightDp?.let { dp(it) } ?: FrameLayout.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER,
                )
            )
        }

        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, 0, 0, dp(24f))
            addView(label)
            addView(
                buttonContainer,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                )
            )
        }
    }
}
