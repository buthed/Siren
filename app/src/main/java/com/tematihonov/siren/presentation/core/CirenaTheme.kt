package com.tematihonov.siren.presentation.core

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tematihonov.siren.R


@Composable
fun SirenTheme(
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    CompositionLocalProvider(
        LocalSRNExtraColors provides srnExtraColors,
        LocalSRNExtraTypography provides srnExtraTypography,
    ) {
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color(0xFF1f1d2b),
            )
        }

        MaterialTheme(
            colors = SRNColors,
            typography = SRNTypography,
            shapes = SRNShapes,
            content = content
        )
    }
}

object SRNTheme {
    val colors: SRNExtraColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSRNExtraColors.current

    val typography: SRNExtraTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSRNExtraTypography.current
}

val LocalSRNExtraColors = staticCompositionLocalOf {
    SRNExtraColors()
}

@Immutable
data class SRNExtraColors(
    val Dark: Color = Color.Unspecified,
    val Soft: Color = Color.Unspecified,
    val BlueAccent: Color = Color.Unspecified,
    val Green: Color = Color.Unspecified,
    val Orange: Color = Color.Unspecified,
    val Red: Color = Color.Unspecified,
    val Black: Color = Color.Unspecified,
    val DarkGray: Color = Color.Unspecified,
    val Gray: Color = Color.Unspecified,
    val WhiteGray: Color = Color.Unspecified,
    val Whiter: Color = Color.Unspecified,
    val LineDark: Color = Color.Unspecified,
)

val LocalSRNExtraTypography = staticCompositionLocalOf {
    SRNExtraTypography()
}

@Immutable
data class SRNExtraTypography(
    val buttonSmall: TextStyle = TextStyle.Default,
    val numpad: TextStyle = TextStyle.Default,
)

val SRNColors: Colors
    @Composable
    @ReadOnlyComposable
    get() = srnLightColors

val srnLightColors = lightColors(
    primary =           Color(0xFF240732),
    onPrimary =         Color.White,
    primaryVariant =    Color(0xFF440a4a),
    background =        Color(0xFFF6F6F6),
    onBackground =      Color.Black,
    surface =           Color.White,
    onSurface =         Color.Black,
    error =             Color(0xFFFF0000),
    onError =           Color.White,
)

val srnExtraColors: SRNExtraColors
    @Composable
    @ReadOnlyComposable
    get() = srnLightExtraColors

val srnLightExtraColors = SRNExtraColors(
    Dark  =                 Color(0xFF1F1D2B),
    Soft =              Color(0xFF252836),
    BlueAccent =             Color(0xFF12CDD9),
    Green =              Color(0xFF22B07D),
    Orange =             Color(0xFFFF8700),
    Red =             Color(0xFFFF7256),
    Black =               Color(0xFF171725),
    DarkGray =             Color(0xFF696974),
    Gray =               Color(0xFF92929D),
    WhiteGray =             Color(0xFFF1F1F5),
    Whiter =               Color(0xFFFFFFFF),
    LineDark = Color(0xFFEAEAEA),
)


val montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold)
)

val baseTextStyle: TextStyle
    @Composable
    @ReadOnlyComposable
    get() = TextStyle(
        color = SRNColors.onSurface,
        fontFamily = montserrat,
        fontWeight = FontWeight.Normal
    )

val SRNTypography: Typography
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.typography.copy(
        h1 = baseTextStyle.copy(
            fontSize = 28.sp, lineHeight = 32.sp, fontWeight = FontWeight.Bold,
        ),
//        h2 = baseTextStyle.copy(
//            fontSize = 24.sp, lineHeight = 28.sp, fontWeight = FontWeight.Medium
//        ),
//        h3 = baseTextStyle.copy(
//            fontSize = 18.sp, lineHeight = 22.sp, fontWeight = FontWeight.Medium,
//        ),
//        h4 = baseTextStyle.copy(
//            fontSize = 16.sp, lineHeight = 20.sp, fontWeight = FontWeight.Medium, color = Color.White
//        ),
//        h5 = baseTextStyle.copy(
//            fontSize = 14.sp, lineHeight = 18.sp, fontWeight = FontWeight.Medium,
//        ),
//        body1 = baseTextStyle.copy(
//            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.SemiBold
//        ),
//        body2 = baseTextStyle.copy(
//            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium, color = Color.White
//        ),
//        subtitle1 = baseTextStyle.copy(
//            fontSize = 12.sp, lineHeight = 16.sp, fontWeight = FontWeight.Medium, color = LocalSRNExtraColors.current.Gray
//        ),
//        subtitle2 = baseTextStyle.copy(
//            fontSize = 10.sp, lineHeight = 14.sp, fontWeight = FontWeight.Medium, color = LocalSRNExtraColors.current.Gray
//        ),
//        button = baseTextStyle.copy(
//            fontSize = 16.sp, lineHeight = 21.sp, fontWeight = FontWeight.Medium
//        ),
//        caption = baseTextStyle.copy(
//            fontSize = 13.sp, lineHeight = 16.sp
//        )
    )

val srnExtraTypography: SRNExtraTypography
    @Composable
    @ReadOnlyComposable
    get() = SRNExtraTypography(
//        buttonSmall = baseTextStyle.copy(
//            fontSize = 14.sp, lineHeight = 17.sp, fontWeight = FontWeight.Bold
//        ),
//        numpad = baseTextStyle.copy(
//            fontSize = 38.sp, lineHeight = 46.sp, fontWeight = FontWeight.Medium
//        )
    )

val SRNShapes: Shapes
    @Composable
    @ReadOnlyComposable
    get() = MaterialTheme.shapes.copy(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp)
    )