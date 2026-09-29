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
    ButtonScenario("1. Default — wrap content, 4dp padding", paddingDp = 4f),
    ButtonScenario("2. Wrap content, 0dp padding", paddingDp = 0f),
    ButtonScenario("3. Wrap content, 16dp padding", paddingDp = 16f),
    ButtonScenario("4. Wrap content, 28dp padding (excessive)", paddingDp = 28f),
    ButtonScenario("5. Square 48x48dp (min tap target), 4dp padding", widthDp = 48f, heightDp = 48f, paddingDp = 4f),
    ButtonScenario("6. Square 48x48dp (min tap target), 12dp padding", widthDp = 48f, heightDp = 48f, paddingDp = 12f),
    ButtonScenario("7. Square 64x64dp, 8dp padding", widthDp = 64f, heightDp = 64f, paddingDp = 8f),
    ButtonScenario("8. Wide/short 160x48dp, 4dp padding", widthDp = 160f, heightDp = 48f, paddingDp = 4f),
    ButtonScenario("9. Wide/short 160x48dp, 16dp padding", widthDp = 160f, heightDp = 48f, paddingDp = 16f),
    ButtonScenario("10. Wide/tall 220x96dp, 8dp padding", widthDp = 220f, heightDp = 96f, paddingDp = 8f),
    ButtonScenario("11. Narrow/tall 64x120dp, 8dp padding", widthDp = 64f, heightDp = 120f, paddingDp = 8f),
    ButtonScenario("12. Wrap width, fixed height 160dp, 8dp padding", heightDp = 160f, paddingDp = 8f),
    ButtonScenario("13. Large corner radius (36dp), wrap content, 8dp padding", cornerRadiusDp = 36f, paddingDp = 8f),
    ButtonScenario("14. Square corners (0dp radius), wrap content, 12dp padding", cornerRadiusDp = 0f, paddingDp = 12f),
)
