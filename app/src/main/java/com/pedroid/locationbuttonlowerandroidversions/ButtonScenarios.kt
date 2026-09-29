package com.pedroid.locationbuttonlowerandroidversions

/**
 * One row in the size / padding / corner-radius matrix.
 *
 * `widthDp`/`heightDp` of `null` means WRAP_CONTENT. `cornerRadiusDp` of `null` means
 * "don't override — let the library apply its own default".
 */
data class ButtonScenario(
    val label: String,
    val widthDp: Float? = null,
    val heightDp: Float? = null,
    val paddingDp: Float,
    val cornerRadiusDp: Float? = null,
)

val buttonScenarios = listOf(
    ButtonScenario("1. Square 48x48dp (min tap target), 4dp padding", widthDp = 48f, heightDp = 48f, paddingDp = 4f),
    ButtonScenario("2. Square 48x48dp (min tap target), 12dp padding", widthDp = 48f, heightDp = 48f, paddingDp = 12f),
    ButtonScenario("3. Square 64x64dp, 8dp padding", widthDp = 64f, heightDp = 64f, paddingDp = 8f),
    ButtonScenario("4. Wide/short 160x48dp, 4dp padding", widthDp = 160f, heightDp = 48f, paddingDp = 4f),
    ButtonScenario("5. Wide/short 160x48dp, 16dp padding", widthDp = 160f, heightDp = 48f, paddingDp = 16f),
    ButtonScenario("6. Wide/tall 220x96dp, 8dp padding", widthDp = 220f, heightDp = 96f, paddingDp = 8f),
    ButtonScenario("7. Narrow/tall 64x120dp, 8dp padding", widthDp = 64f, heightDp = 120f, paddingDp = 8f),
    ButtonScenario("8. Wrap width, fixed height 160dp, 8dp padding", heightDp = 160f, paddingDp = 8f),
)
